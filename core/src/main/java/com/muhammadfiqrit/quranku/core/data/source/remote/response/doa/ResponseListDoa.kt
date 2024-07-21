package com.muhammadfiqrit.quranku.core.data.source.remote.response.doa

import com.google.gson.annotations.SerializedName

data class ResponseListDoa(
    @field:SerializedName("status") val status: Boolean,
    @field:SerializedName("data") val data: List<ResponseDoa>
)