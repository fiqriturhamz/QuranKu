package com.muhammadfiqrit.quranku.core.data

import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkOnlyResource<ResultType, RequestType> {

    private val result: Flow<com.muhammadfiqrit.quranku.core.data.Resource<ResultType>> = flow {
        emit(com.muhammadfiqrit.quranku.core.data.Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success -> {
                emitAll(loadFromNetwork(apiResponse.data).map {
                    com.muhammadfiqrit.quranku.core.data.Resource.Success(it)
                })
            }
            is ApiResponse.Error -> emit(
                com.muhammadfiqrit.quranku.core.data.Resource.Error(
                    apiResponse.errorMessage
                )
            )
            is ApiResponse.Empty -> emit(
                com.muhammadfiqrit.quranku.core.data.Resource.Error(
                    "empty data"
                )
            )
        }
    }


    protected abstract fun loadFromNetwork(data: RequestType): Flow<ResultType>

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    fun asFlow(): Flow<com.muhammadfiqrit.quranku.core.data.Resource<ResultType>> = result
}