package com.muhammadfiqrit.quranku.core.data.source.remote

import android.util.Log
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.network.LokasiService
import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi.ResponseSemuaLokasiItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class LokasiRemoteDataSource(private val lokasiService: LokasiService) {
    suspend fun getSemuaLokasi(): Flow<ApiResponse<List<ResponseSemuaLokasiItem>>> {
        return flow {
            try {
                val response = lokasiService.getAllKota()
                val data = response.data
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    Log.e("error", "error")
                }
            } catch (e:Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("Remote.getLokasi",e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}