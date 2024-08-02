package com.muhammadfiqrit.quranku.core.data

import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.hadits.ResponseListHaditsArbain
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface HaditsService {
    @GET("v2/hadits/arbain/semua")
    suspend fun getSemuaHaditsArbain() : ResponseListHaditsArbain
}