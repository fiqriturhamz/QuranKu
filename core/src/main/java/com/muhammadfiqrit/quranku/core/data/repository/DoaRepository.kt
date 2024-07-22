package com.muhammadfiqrit.quranku.core.data.repository

import com.muhammadfiqrit.quranku.core.data.NetworkBoundResource
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.data.source.local.DoaLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.local.HusnaLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.DoaRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.doa.ResponseDoa
import com.muhammadfiqrit.quranku.core.domain.model.doa.Doa
import com.muhammadfiqrit.quranku.core.domain.repository.IDoaRepository
import com.muhammadfiqrit.quranku.core.utils.AppExecutors
import com.muhammadfiqrit.quranku.core.utils.DataMapperDoa
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DoaRepository(
    private val appExecutors: AppExecutors,
    private val doaRemoteDataSource: DoaRemoteDataSource,
    private val doaLocalDataSource: DoaLocalDataSource
) : IDoaRepository {
    override fun getAllDoa(keyword: String): Flow<Resource<List<Doa>>> {
        return object : NetworkBoundResource<List<Doa>, List<ResponseDoa>>() {
            override fun loadFromDB(): Flow<List<Doa>> {
                return doaLocalDataSource.getAllDoa().map { DataMapperDoa.mapDoaEntitiesToDoas(it) }

            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseDoa>>> {
                return doaRemoteDataSource.getAllDoaByKeyword(keyword = keyword)
            }

            override suspend fun saveCallResult(data: List<ResponseDoa>) {
                val doaEntities = DataMapperDoa.mapDataDoaResponsesToDoaEntities(data)
                doaLocalDataSource.insertDoa(doaEntities)
            }

            override fun shouldFetch(data: List<Doa>?): Boolean {
                return true
            }

        }.asFlow()
    }
}