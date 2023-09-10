package com.muhammadfiqrit.quranku.data.source.remote

import android.util.Log
import com.muhammadfiqrit.quranku.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.data.source.remote.network.ApiService
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.DataDetailSuratResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.surat.SuratResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.Exception


class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllSurat(): Flow<ApiResponse<List<SuratResponse>>> {

        return flow {
            try {
                val response = apiService.getSurat()
                val dataArray = response.data
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("Remote.getSurat", e.toString())
            }
        }.flowOn(Dispatchers.IO)

    }


    suspend fun getDetailSurat(nomorSurat : Int) : Flow<ApiResponse<DataDetailSuratResponse>>{
        return flow {
            try {
                val response = apiService.getDetailSurat(nomorSurat)
                val data = response.data
                if (data != null){
                    emit(ApiResponse.Success(response.data))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("Remote.getDetailSurat", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}