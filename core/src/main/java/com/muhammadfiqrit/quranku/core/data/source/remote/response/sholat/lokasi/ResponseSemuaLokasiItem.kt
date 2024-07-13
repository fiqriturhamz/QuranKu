package com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi

import com.google.gson.annotations.SerializedName

data class ResponseSemuaLokasiItem(

    @field:SerializedName("lokasi")
    val lokasi: String,

    @field:SerializedName("id")
    val id: String
)
