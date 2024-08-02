package com.muhammadfiqrit.quranku.core.domain.model.surat

import android.os.Parcelable
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.core.domain.model.detail.SuratSelanjutnya
import kotlinx.parcelize.Parcelize


data class Surat(
    val nomor: Int,
    val nama: String,
    val jumlahAyat: Int,
    val arti: String,
    val namaLatin: String,
    val deskripsi: String,
    val tempatTurun: String,
    var isFavorite: Boolean,

)
