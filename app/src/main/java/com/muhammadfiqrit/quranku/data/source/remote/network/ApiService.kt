package com.muhammadfiqrit.quranku.data.source.remote.network

import com.muhammadfiqrit.quranku.data.source.remote.response.DetailSuratResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.surat.ListSuratResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("surat")
    suspend fun getSurat() : ListSuratResponse


    @GET("surat/{nomor_surat}")
    suspend fun getDetailSurat(@Path("nomor_surat") nomorSurat : Int) : DetailSuratResponse


}