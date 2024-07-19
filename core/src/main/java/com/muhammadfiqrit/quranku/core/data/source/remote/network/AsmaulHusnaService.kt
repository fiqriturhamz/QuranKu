package com.muhammadfiqrit.quranku.core.data.source.remote.network

import com.muhammadfiqrit.quranku.core.data.source.remote.response.husna.ResponseListHusna
import retrofit2.http.GET

interface AsmaulHusnaService {
    @GET("v2/husna/semua")
    fun getSemuaAsmaulHusna() : ResponseListHusna
}