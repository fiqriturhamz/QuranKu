package com.muhammadfiqrit.quranku.core.data.source.remote.response.detail

import com.google.gson.annotations.SerializedName

data class DataDetailSuratResponse(

    @field:SerializedName("jumlahAyat")
    val jumlahAyat: Int,

    @field:SerializedName("nama")
    val nama: String,

    @field:SerializedName("suratSebelumnya")
    val suratSebelumnya: Any,

    @field:SerializedName("tempatTurun")
    val tempatTurun: String,
    @field:SerializedName("ayat")
    val ayat: List<AyatResponse>,

    @field:SerializedName("arti")
    val arti: String,

    @field:SerializedName("deskripsi")
    val deskripsi: String,

    @field:SerializedName("suratSelanjutnya")
    val suratSelanjutnyaResponse: SuratSelanjutnyaResponse,

    @field:SerializedName("nomor")
    val nomor: Int,

    @field:SerializedName("audio")
    val audio: AudioResponse,

    @field:SerializedName("namaLatin")
    val namaLatin: String
)