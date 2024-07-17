package com.muhammadfiqrit.quranku.core.data.source.remote

import android.util.Log
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.network.SuratService
import com.muhammadfiqrit.quranku.core.data.source.remote.response.detail.DataDetailSuratResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.surat.ResponseSurat
import com.muhammadfiqrit.quranku.core.data.source.remote.response.tafsir.ListTafsirResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class SuratRemoteDataSource(private val suratService: SuratService) {

    suspend fun getAllSurat(): Flow<ApiResponse<List<ResponseSurat>>> {

        return flow {
            try {
                val response = suratService.getSurat()
                val data = response.data
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                  Log.e("error", "error")
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("Remote.getSurat", e.toString())
            }
        }.flowOn(Dispatchers.IO)

    }


    suspend fun getDetailSurat(nomorSurat: Int): Flow<ApiResponse<DataDetailSuratResponse>> {
        return flow {
            try {
                val response = suratService.getDetailSurat(nomorSurat)
                val data = response.data
                if (data != null) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("Remote.getDetailSurat", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getTafsir(nomorSurat: Int): Flow<ApiResponse<ListTafsirResponse>> {
        return flow {
            try {
                val response = suratService.getTafsir(nomorSurat)
                val data = response.data
                if (data != null) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("Remote.getTafsir", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }


}