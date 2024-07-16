package com.muhammadfiqrit.quranku.core.data.Repository

import android.provider.ContactsContract.Data
import com.muhammadfiqrit.quranku.core.data.NetworkBoundResource
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.data.source.local.SuratLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.SuratRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.detail.DataDetailSuratResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.surat.ResponseSurat
import com.muhammadfiqrit.quranku.core.data.source.remote.response.tafsir.ListTafsirResponse
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat

import com.muhammadfiqrit.quranku.core.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.TafsirItem
import com.muhammadfiqrit.quranku.core.domain.repository.ISuratRepository
import com.muhammadfiqrit.quranku.core.utils.AppExecutors
import com.muhammadfiqrit.quranku.core.utils.DataMapperSurat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

class SuratRepository(
    private val suratRemoteDataSource: SuratRemoteDataSource,
    private val suratLocalDataSource: SuratLocalDataSource,
    private val appExecutors: AppExecutors,

    ) : ISuratRepository {
    override fun getAllSurat(): Flow<Resource<List<Surat>>> =
        object :
            NetworkBoundResource<List<Surat>, List<ResponseSurat>>() {
            override fun loadFromDB(): Flow<List<Surat>> {
                return suratLocalDataSource.getAllSurat()
                    .map { DataMapperSurat.mapSuratEntitiesToSurats(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseSurat>>> =
                suratRemoteDataSource.getAllSurat()

            override suspend fun saveCallResult(data: List<ResponseSurat>) {
                val suratList = DataMapperSurat.mapSuratResponsesToSuratEntities(data)
                suratLocalDataSource.insertSurat(suratList)
            }

            override fun shouldFetch(data: List<Surat>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getSuratByNomor(nomorSurat: Int): Flow<Resource<DetailSurat>> {


        return object : NetworkBoundResource<DetailSurat, DataDetailSuratResponse>() {
            override fun loadFromDB(): Flow<DetailSurat> {
                val suratFlow = suratLocalDataSource.getSuratByNomor(nomorSurat)
                    .map { DataMapperSurat.mapSuratEntityToDetailSurat(it) }

                val ayatFlow = suratLocalDataSource.getAyatBySurat(nomorSurat)
                    .map { DataMapperSurat.mapAyatEntitiesToAyat(it) }

                val suratSelanjutnyaFlow =
                    suratLocalDataSource.getSuratSelanjutnya(nomorSurat).map {
                        DataMapperSurat.suratSelanjutnyaEntityToSuratSelanjutnya(
                            it,
                        )
                    }


                return combine(
                    suratFlow,
                    ayatFlow,
                    suratSelanjutnyaFlow,

                    ) { surat, ayat, suratSelanjutnya ->
                    // Now you have all three data types you need
                    DetailSurat(surat, ayat, suratSelanjutnya)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<DataDetailSuratResponse>> {
                return suratRemoteDataSource.getDetailSurat(nomorSurat)
            }

            override suspend fun saveCallResult(data: DataDetailSuratResponse) {
                val surat = DataMapperSurat.mapDataDetailSuratResponseToSuratEntity(data)
                val ayat = DataMapperSurat.mapAyatResponsesToAyatEntities(data.ayat, nomorSurat)
                val suratSelanjutnya =
                    DataMapperSurat.suratSelanjutnyaResponseToSuratSelanjutnyaEntities(
                        data.suratSelanjutnyaResponse,
                        nomorSurat
                    )

                suratLocalDataSource.insertDetailSurat(surat)
                suratLocalDataSource.insertAyat(ayat)
                suratLocalDataSource.insertSuratSelanjutnya(suratSelanjutnya = suratSelanjutnya)
            }

            override fun shouldFetch(data: DetailSurat?): Boolean {

                //sama kaya data?.ayat != null
                //pengambilan data di internet terus

                return data != null

            }

        }.asFlow()
    }


    override fun getFavoriteSurat(): Flow<List<Surat>> {
        return suratLocalDataSource.getFavoriteSurat().map {
            DataMapperSurat.mapSuratEntitiesToSurats(it)
        }
    }

    override fun setFavoriteSurat(surat: DetailSurat, newState: Boolean) {
        val suratEntity = DataMapperSurat.mapDetailSuratToSuratEntity(surat)
        appExecutors.diskIO().execute {
            suratLocalDataSource.setFavoriteSurat(suratEntity, newState)
        }
    }

    override fun getAyatTerakhirDibaca(): Flow<Ayat> {
        return suratLocalDataSource.getAyatTerakhirDibaca().map {
            DataMapperSurat.mapAyatEntityToAyat(it)
        }
    }

    override fun setAyatTerakhirDibaca(ayat: Ayat, newState: Boolean) {
        val ayatEntity = DataMapperSurat.mapAyatToAyatEntity(ayat)
        appExecutors.diskIO().execute {
            suratLocalDataSource.setAyatTerakhirDibaca(ayatEntity, newState)
        }
    }

    override fun getTafsir(nomorSurat: Int): Flow<Resource<List<TafsirItem>>> {
        return object : NetworkBoundResource<List<TafsirItem>, ListTafsirResponse>() {
            override fun loadFromDB(): Flow<List<TafsirItem>> {
                return suratLocalDataSource.getTafsir(nomorSurat)
                    .map { DataMapperSurat.tafsirEntitiesToTafsir(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<ListTafsirResponse>> {
                return suratRemoteDataSource.getTafsir(nomorSurat)
            }

            override suspend fun saveCallResult(data: ListTafsirResponse) {
                val tafsir = DataMapperSurat.tafsirResponseToTafsirEntity(data.tafsir, nomorSurat)
                suratLocalDataSource.insertTafsir(tafsir)
            }

            override fun shouldFetch(data: List<TafsirItem>?): Boolean {
                return data != null
            }

        }.asFlow()
    }
}