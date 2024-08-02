package com.muhammadfiqrit.quranku.core.data.source.remote.response.husna

import com.google.gson.annotations.SerializedName

data class ResponseHusna(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("arab")
    val teksArab: String,
    @field:SerializedName("indo")
    val teksIndo: String,
    @field:SerializedName("latin")
    val teksLatin: String
)
