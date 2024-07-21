package com.muhammadfiqrit.quranku.core.data.source.remote.network

import com.muhammadfiqrit.quranku.core.data.source.remote.response.doa.ResponseListDoa
import retrofit2.http.GET

interface DoaService {
    @GET("doa/sumber/{keyword}")
    suspend fun getAllDoaByKeyword(keyword: String): ResponseListDoa
}