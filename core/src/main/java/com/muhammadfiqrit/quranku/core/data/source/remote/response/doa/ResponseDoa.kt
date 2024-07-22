package com.muhammadfiqrit.quranku.core.data.source.remote.response.doa

import com.google.gson.annotations.SerializedName

data class ResponseDoa(
    @field:SerializedName("arab")
    val teksArab: String,
    @field:SerializedName("indo")
    val teksIndo: String,
    @field:SerializedName("judul")
    val judul: String,
    @field:SerializedName("source")
    val source: String
)
