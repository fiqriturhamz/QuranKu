package com.muhammadfiqrit.quranku.core.data.repository

import com.muhammadfiqrit.quranku.core.data.NetworkBoundResource
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.data.source.local.HaditsLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.HaditsRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.hadits.ResponseHaditsArbain
import com.muhammadfiqrit.quranku.core.domain.model.hadits.Hadits
import com.muhammadfiqrit.quranku.core.domain.repository.IHaditsRepository
import com.muhammadfiqrit.quranku.core.utils.AppExecutors
import com.muhammadfiqrit.quranku.core.utils.DataMapperHadits
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HaditsRepository(
    private val appExecutors: AppExecutors,
    private val haditsLocalDataSource: HaditsLocalDataSource,
    private val haditsRemoteDataSource: HaditsRemoteDataSource
) : IHaditsRepository {
    override fun getAllHaditsArbain(): Flow<Resource<List<Hadits>>> {
        return object : NetworkBoundResource<List<Hadits>, List<ResponseHaditsArbain>>() {
            override fun loadFromDB(): Flow<List<Hadits>> {
                return haditsLocalDataSource.getAllHaditsArbain()
                    .map { DataMapperHadits.mapHaditsEntitiesToHadits(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseHaditsArbain>>> {
                return haditsRemoteDataSource.getAllHaditsArbain()
            }

            override suspend fun saveCallResult(data: List<ResponseHaditsArbain>) {
                val data = DataMapperHadits.mapHaditsResponsesToHaditsEntities(data)
                haditsLocalDataSource.insertAllHaditsArbain(data)

            }

            override fun shouldFetch(data: List<Hadits>?): Boolean {
                return data.isNullOrEmpty()
            }

        }.asFlow()
    }
}