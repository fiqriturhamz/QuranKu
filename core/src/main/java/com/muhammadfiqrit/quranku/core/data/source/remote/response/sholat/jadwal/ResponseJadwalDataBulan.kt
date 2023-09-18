package com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.jadwal

import com.google.gson.annotations.SerializedName

data class ResponseJadwalDataBulan(

    @field:SerializedName("jadwal")
    val jadwal: List<ResponseJadwal>,

    @field:SerializedName("lokasi")
    val lokasi: String,

    @field:SerializedName("daerah")
    val daerah: String,

    @field:SerializedName("id")
    val id: String,

    )
