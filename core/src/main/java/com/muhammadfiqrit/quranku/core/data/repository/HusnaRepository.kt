package com.muhammadfiqrit.quranku.core.data.repository

import com.muhammadfiqrit.quranku.core.data.NetworkBoundResource
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.data.source.local.HusnaLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.HusnaRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.husna.ResponseHusna
import com.muhammadfiqrit.quranku.core.domain.model.husna.Husna
import com.muhammadfiqrit.quranku.core.domain.repository.IHusnaRepository
import com.muhammadfiqrit.quranku.core.utils.AppExecutors
import com.muhammadfiqrit.quranku.core.mapper.HusnaMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HusnaRepository(
    private val appExecutors: AppExecutors,
    private val husnaRemoteDataSource: HusnaRemoteDataSource,
    private val husnaLocalDataSource: HusnaLocalDataSource
) : IHusnaRepository {
    override fun getAllAsmaulHusna(): Flow<Resource<List<Husna>>> {
        return object : NetworkBoundResource<List<Husna>, List<ResponseHusna>>() {
            override fun loadFromDB(): Flow<List<Husna>> {
                return husnaLocalDataSource.getAllAsmaulHusna()
                    .map { HusnaMapper.entitiesToDomain(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseHusna>>> {
                return husnaRemoteDataSource.getAllAsmaulHusna()
            }

            override suspend fun saveCallResult(data: List<ResponseHusna>) {
                val husna = HusnaMapper.responsesToEntities(data)
                husnaLocalDataSource.insertHusna(husna)
            }

            override fun shouldFetch(data: List<Husna>?): Boolean {
                return data.isNullOrEmpty()
            }

        }.asFlow()
    }
}