package com.muhammadfiqrit.quranku.core.data.source.remote

import android.util.Log
import com.muhammadfiqrit.quranku.core.data.HaditsService
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.hadits.ResponseHaditsArbain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HaditsRemoteDataSource(private val haditsService: HaditsService) {
    suspend fun getAllHaditsArbain(): Flow<ApiResponse<List<ResponseHaditsArbain>>> {
        return flow {
            try {
                val response = haditsService.getSemuaHaditsArbain()
                val data = response.data
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    Log.e("Remote.getSemuaHaditsArbain", response.status.toString())
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("Remote.getSemuaHaditsArbain", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}