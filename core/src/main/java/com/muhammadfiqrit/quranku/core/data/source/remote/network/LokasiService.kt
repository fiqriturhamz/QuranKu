package com.muhammadfiqrit.quranku.core.data.source.remote.network

import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi.ResponseSemuaLokasi
import retrofit2.http.GET
import retrofit2.http.Path

interface LokasiService {
    //Dapatkan semua nama kota dan id kota
    @GET("v2/sholat/kota/semua")
    suspend fun getAllKota() : ResponseSemuaLokasi
}