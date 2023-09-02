package com.muhammadfiqrit.quranku.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.muhammadfiqrit.quranku.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.data.source.remote.network.ApiService
import com.muhammadfiqrit.quranku.data.source.remote.response.ListSuratResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.SuratResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
        }
    }

    fun getAllSurat(): LiveData<ApiResponse<List<SuratResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<SuratResponse>>>()

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
        return resultData
    }
}