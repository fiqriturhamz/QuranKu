package com.muhammadfiqrit.quranku.core.data.source.remote.response.detail

import com.google.gson.annotations.SerializedName

data class AudioResponse(

    @field:SerializedName("01")
    val audio1: String? = null,

    @field:SerializedName("02")
    val audio2: String? = null,

    @field:SerializedName("03")
    val audio3: String? = null,

    @field:SerializedName("04")
    val audio4: String? = null,

    @field:SerializedName("05")
    val audio5: String? = null
)
