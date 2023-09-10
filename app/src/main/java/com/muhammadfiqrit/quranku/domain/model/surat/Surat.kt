package com.muhammadfiqrit.quranku.domain.model.surat

import android.os.Parcelable
import com.muhammadfiqrit.quranku.domain.model.detail.Ayat
import kotlinx.parcelize.Parcelize


data class Surat(
    val nomor : Int,
    val nama :  String,
    val jumlahAyat : Int,
    val arti : String,
    val namaLatin : String,
    val deskripsi : String,
    val tempatTurun : String,


)
