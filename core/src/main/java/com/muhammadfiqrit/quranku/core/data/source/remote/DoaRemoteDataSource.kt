package com.muhammadfiqrit.quranku.core.data.source.remote

import android.util.Log
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.network.DoaService
import com.muhammadfiqrit.quranku.core.data.source.remote.response.doa.ResponseDoa
import com.muhammadfiqrit.quranku.core.data.source.remote.response.doa.ResponseListDoa
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DoaRemoteDataSource(private val doaService: DoaService) {
    suspend fun getAllDoaByKeyword(keyword: String): Flow<ApiResponse<List<ResponseDoa>>> {
        return flow {
            try {
                val response = doaService.getAllDoaByKeyword(keyword)
                val data = response.data
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
                Log.e("Remote.getAllDoaByKeyword", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}