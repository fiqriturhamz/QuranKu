package com.muhammadfiqrit.quranku.core.data.source.remote.response.detail

import com.google.gson.annotations.SerializedName

data class SuratSelanjutnyaResponse(

    @field:SerializedName("jumlahAyat")
    val jumlahAyat: Int,

    @field:SerializedName("nama")
    val nama: String,

    @field:SerializedName("nomor")
    val nomor: Int,

    @field:SerializedName("namaLatin")
    val namaLatin: String
)
