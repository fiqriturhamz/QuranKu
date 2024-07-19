package com.muhammadfiqrit.quranku.core.data.source.remote

import android.util.Log
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.network.AsmaulHusnaService
import com.muhammadfiqrit.quranku.core.data.source.remote.response.husna.ResponseHusna
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class HusnaRemoteDataSource(private val asmaulHusnaService: AsmaulHusnaService) {
    suspend fun getAllAsmaulHusna(): Flow<ApiResponse<List<ResponseHusna>>> {
        return flow {
            try {
                val response = asmaulHusnaService.getSemuaAsmaulHusna()
                val data = response.data
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    Log.e("getAllAsmaulHusna", response.status.toString())

                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("Remote.getAllHusna", e.toString())
            }
        }.flowOn(Dispatchers.IO)

    }

}