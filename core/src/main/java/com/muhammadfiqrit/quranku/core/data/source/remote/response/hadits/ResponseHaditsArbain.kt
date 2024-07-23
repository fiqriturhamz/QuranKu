package com.muhammadfiqrit.quranku.core.data.source.remote.response.hadits

import com.google.gson.annotations.SerializedName

data class ResponseHaditsArbain(
    @field:SerializedName("arab")
    val teksArab: String,
    @field:SerializedName("indo")
    val teksIndo: String,
    @field:SerializedName("judul")
    val judulHadits: String,
    @field:SerializedName("no")
    val noHadits: String
)