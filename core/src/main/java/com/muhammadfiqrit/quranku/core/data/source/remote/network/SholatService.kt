package com.muhammadfiqrit.quranku.core.data.source.remote.network

import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.jadwal.ResponseJadwalSholatByBulan
import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.jadwal.ResponseJadwalSholatByHari
import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi.ResponseKotaBySearch
import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi.ResponseSemuaKota
import retrofit2.http.GET
import retrofit2.http.Path

interface SholatService {

    //Jadwal sholat per hari
    @GET("v1/sholat/jadwal/{id_kota}/{hari}")
    suspend fun getJadwalSholatPerHari(@Path("hari") hari: String, @Path("id_kota") idKota : Int) : ResponseJadwalSholatByHari


    //Jadwal sholat per bulan
    @GET("v1/sholat/jadwal/{id_kota}/{bulan}")
    suspend fun getJadwalSholatPerBulan(@Path("bulan") bulan: String) : ResponseJadwalSholatByBulan

    //Dapatkan semua nama kota dan id kota
    @GET("v1/sholat/kota/semua")
    suspend fun getAllKota() : ResponseSemuaKota

    @GET("v1/sholat/kota/cari/{kota}")
    suspend fun getAllKotaBySearch(@Path("kota") kota : String) : ResponseKotaBySearch
}