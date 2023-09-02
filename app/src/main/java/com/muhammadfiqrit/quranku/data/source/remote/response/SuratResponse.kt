package com.muhammadfiqrit.quranku.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SuratResponse(

    @field:SerializedName("nomor")
    val nomor: Int,

    @field:SerializedName("nama")
    val nama: String,

    @field:SerializedName("jumlahAyat")
    val jumlahAyat: Int,

    @field:SerializedName("tempatTurun")
    val tempatTurun: String,

    @field:SerializedName("arti")
    val arti: String,

    @field:SerializedName("deskripsi")
    val deskripsi: String,

    @field:SerializedName("namaLatin")
    val namaLatin: String
)
