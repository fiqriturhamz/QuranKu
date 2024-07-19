package com.muhammadfiqrit.quranku.core.data.source.remote.response.husna

import com.google.gson.annotations.SerializedName

data class ResponseListHusna(
    @field:SerializedName("status")
    val status: Boolean,
    @field:SerializedName("data")
    val data: List<ResponseHusna>
)