package com.muhammadfiqrit.quranku.core.data.source.remote

import android.util.Log
import android.widget.Toast
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.network.SholatService
import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.jadwal.ResponseJadwalDataHarian
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class SholatRemoteDataSource(private val sholatService: SholatService) {
    suspend fun getJadwalSholatPerHari(hari: String, idKota : Int): Flow<ApiResponse<ResponseJadwalDataHarian>> {

        return flow {
            val response = sholatService.getJadwalSholatPerHari(hari, idKota)
            val data = response.data
            if(response.status){
                if (data != null) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }

            }else {


            }
           /* try {
                val response = sholatService.getJadwalSholatPerHari(hari, idKota)
                val data = response.data
                if (data != null) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {

                emit(ApiResponse.Error(e.toString()))
                Log.e("Remote.getSholat", e.toString())


            }*/
        }.flowOn(Dispatchers.IO)
    }
}