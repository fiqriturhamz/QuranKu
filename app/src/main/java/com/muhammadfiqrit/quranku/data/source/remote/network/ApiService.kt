package com.muhammadfiqrit.quranku.data.source.remote.network

import com.muhammadfiqrit.quranku.data.source.remote.response.ListSuratResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("surat")
    fun getSurat() : Call<ListSuratResponse>
}