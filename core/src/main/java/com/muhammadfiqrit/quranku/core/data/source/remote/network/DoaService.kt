package com.muhammadfiqrit.quranku.core.data.source.remote.network

import com.muhammadfiqrit.quranku.core.data.source.remote.response.doa.ResponseListDoa
import retrofit2.http.GET
import retrofit2.http.Path

interface DoaService {
    @GET("v2/doa/sumber/{keyword}")
    suspend fun getAllDoaByKeyword(@Path("keyword") keyword:String): ResponseListDoa
}