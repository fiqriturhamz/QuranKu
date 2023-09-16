package com.muhammadfiqrit.quranku.core.data.source.remote.response.tafsir

import com.google.gson.annotations.SerializedName

data class TafsirItemResponse(

    @field:SerializedName("ayat")
    val ayat: Int,

    @field:SerializedName("teks")
    val teks: String
)
