package com.muhammadfiqrit.quranku.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.muhammadfiqrit.quranku.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.data.source.remote.network.ApiService
import com.muhammadfiqrit.quranku.data.source.remote.response.ListSuratResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.SuratResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllSurat(): Flow<ApiResponse<List<SuratResponse>>> {

        return flow {
            try {
                val response = apiService.getSurat()
                val dataArray = response.data
                if(dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.data))
                }else
                {
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
      /*  val resultData = MutableLiveData<ApiResponse<List<SuratResponse>>>()

        val client = apiService.getSurat()
        client.enqueue(object : Callback<ListSuratResponse> {
            override fun onResponse(
                call: Call<ListSuratResponse>,
                response: Response<ListSuratResponse>
            ) {
                if (response.isSuccessful) {
                    val dataArray = response.body()?.data
                    if (dataArray != null) {
                        resultData.value = ApiResponse.Success(dataArray)
                    } else ApiResponse.Empty
                }

            }

            override fun onFailure(call: Call<ListSuratResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }

        })
        return resultData*/
    }
}