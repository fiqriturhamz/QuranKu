package com.muhammadfiqrit.quranku.core.data.source.remote.network

import com.muhammadfiqrit.quranku.core.data.source.remote.response.surat.ListSuratResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.tafsir.TafsirResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.DetailSuratResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("surat")
    suspend fun getSurat() : ListSuratResponse


    @GET("surat/{nomor_surat}")
    suspend fun getDetailSurat(@Path("nomor_surat") nomorSurat : Int) : DetailSuratResponse

    @GET("tafsir/{nomor_surat}")
    suspend fun getTafsir(@Path("nomor_surat") nomorSurat: Int) : TafsirResponse


}