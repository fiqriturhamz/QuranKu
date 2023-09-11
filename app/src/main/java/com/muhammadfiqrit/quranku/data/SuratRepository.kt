package com.muhammadfiqrit.quranku.data

import com.muhammadfiqrit.quranku.data.source.local.LocalDataSource
import com.muhammadfiqrit.quranku.data.source.remote.RemoteDataSource
import com.muhammadfiqrit.quranku.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.DataDetailSuratResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.surat.SuratResponse
import com.muhammadfiqrit.quranku.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.domain.repository.ISuratRepository
import com.muhammadfiqrit.quranku.utils.AppExecutors
import com.muhammadfiqrit.quranku.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map

class SuratRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISuratRepository {
    override fun getAllSurat(): Flow<Resource<List<Surat>>> =
        object : NetworkBoundResource<List<Surat>, List<SuratResponse>>() {
            override fun loadFromDB(): Flow<List<Surat>> {
                return localDataSource.getAllSurat().map { DataMapper.mapSuratEntitiesToSurats(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<SuratResponse>>> =
                remoteDataSource.getAllSurat()


            override suspend fun saveCallResult(data: List<SuratResponse>) {
                val suratList = DataMapper.mapSuratResponsesToSuratEntities(data)
                localDataSource.insertSurat(suratList)
            }

            override fun shouldFetch(data: List<Surat>?): Boolean =
                data.isNullOrEmpty()

        }.asFlow()

    override fun getSuratByNomor(nomorSurat: Int): Flow<Resource<DetailSurat>> {


        return object : NetworkBoundResource<DetailSurat, DataDetailSuratResponse>() {
            override fun loadFromDB(): Flow<DetailSurat> {
                val suratFlow = localDataSource.getSuratByNomor(nomorSurat)
                    .map { DataMapper.mapSuratEntityToDetailSurat(it) }

                return suratFlow.flatMapConcat { surat ->
                   localDataSource.getAyatBySurat(nomorSurat).map { ayat ->
                       val ayatDomain = DataMapper.mapAyatEntitiesToAyat(ayat)
                        val detailSurat = DetailSurat(surat,ayatDomain)
                        detailSurat
                    }
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<DataDetailSuratResponse>> {
                return remoteDataSource.getDetailSurat(nomorSurat)
            }

            override suspend fun saveCallResult(data: DataDetailSuratResponse) {
                val surat = DataMapper.mapDataDetailSuratResponseToSuratEntity(data)
                val ayat = DataMapper.mapAyatResponsesToAyatEntities(data.ayat, nomorSurat)
                localDataSource.insertDetailSurat(surat)
                localDataSource.insertAyat(ayat)
            }

            override fun shouldFetch(data: DetailSurat?): Boolean = data != null


        }.asFlow()
    }


    override fun getFavoriteSurat(): Flow<List<Surat>> {
        return localDataSource.getFavoriteSurat().map {
            DataMapper.mapSuratEntitiesToSurats(it)
        }
    }

    override fun setFavoriteSurat(surat: DetailSurat, newState: Boolean) {
        val suratEntity = DataMapper.mapDetailSuratToSuratEntity(surat)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteSurat(suratEntity, newState)
        }
    }
}