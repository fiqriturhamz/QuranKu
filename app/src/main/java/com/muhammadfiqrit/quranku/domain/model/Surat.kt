package com.muhammadfiqrit.quranku.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Surat(
    val nomorSurat : Int,
    val namaSurat :  String,
    val jumlahAyat : Int,
    val arti : String,
    val namaLatin : String,
    val deskripsi : String,
    val tempatTurun : String
) : Parcelable
