package com.muhammadfiqrit.quranku.data.source.remote.response.detail

import com.google.gson.annotations.SerializedName


data class AyatResponse(

    @field:SerializedName("teksArab")
    val teksArab: String,

    @field:SerializedName("teksLatin")
    val teksLatin: String,

    @field:SerializedName("nomorAyat")
    val nomorAyat: Int,

    @field:SerializedName("audio")
    val audioResponse: AudioResponse,

    @field:SerializedName("teksIndonesia")
    val teksIndonesia: String
)
