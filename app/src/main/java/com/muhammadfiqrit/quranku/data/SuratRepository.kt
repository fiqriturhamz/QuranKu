package com.muhammadfiqrit.quranku.data

import com.muhammadfiqrit.quranku.data.source.local.LocalDataSource
import com.muhammadfiqrit.quranku.data.source.remote.RemoteDataSource
import com.muhammadfiqrit.quranku.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.DataDetailSuratResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.surat.SuratResponse
import com.muhammadfiqrit.quranku.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.domain.repository.ISuratRepository
import com.muhammadfiqrit.quranku.utils.AppExecutors
import com.muhammadfiqrit.quranku.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SuratRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISuratRepository {
    override fun getAllSurat(): Flow<Resource<List<Surat>>> =
        object : NetworkBoundResource<List<Surat>, List<SuratResponse>>() {
            override fun loadFromDB(): Flow<List<Surat>> {
                return localDataSource.getAllSurat().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<SuratResponse>>> =
                remoteDataSource.getAllSurat()


            override suspend fun saveCallResult(data: List<SuratResponse>) {
                val suratList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertSurat(suratList)
            }

            override fun shouldFetch(data: List<Surat>?): Boolean =
                data == null || data.isEmpty()

        }.asFlow()

    override fun getSuratByNomor(nomorSurat: Int): Flow<Resource<DetailSurat>> {
        return object : NetworkOnlyResource<DetailSurat, DataDetailSuratResponse>() {
            override fun loadFromNetwork(data: DataDetailSuratResponse): Flow<DetailSurat> {
                return DataMapper.mapResponseToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<DataDetailSuratResponse>> {
                return remoteDataSource.getDetailSurat(nomorSurat)
            }

        }.asFlow()
    }



     /* override fun getSuratByNomor(nomorSurat: Int): Flow<Resource<DetailSurat>> {
          return object : NetworkBoundResource<DetailSurat, DataDetailSuratResponse>() {
              override fun loadFromDB(): Flow<DetailSurat> {
                  return localDataSource.getSuratByNomor(nomorSurat)
                      .map { DataMapper.mapEntityToDomain(it, ayatDao = it. ) }
              }

              override suspend fun createCall(): Flow<ApiResponse<DataDetailSuratResponse>> {
                  return remoteDataSource.getDetailSurat(nomorSurat)
              }

              override suspend fun saveCallResult(data: DataDetailSuratResponse) {
                  val surat = DataMapper.mapResponseToEntity(data)
                  localDataSource.insertDetailSurat(surat)
              }

              override fun shouldFetch(data: DetailSurat?): Boolean {
                  return data == null
              }

          }.asFlow()
      }*/

}