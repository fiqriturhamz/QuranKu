package com.muhammadfiqrit.quranku.core.data.source.remote.response.tafsir

import com.google.gson.annotations.SerializedName

data class ListTafsirResponse(

    @field:SerializedName("tafsir")
    val tafsir: List<TafsirItemResponse>,
    )