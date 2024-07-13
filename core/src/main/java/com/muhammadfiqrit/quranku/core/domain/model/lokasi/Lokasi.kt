package com.muhammadfiqrit.quranku.core.domain.model.lokasi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Lokasi(
    val idLokasi: String = "1032",
    val namaLokasi: String = "Jakarta",
    val lokasiSekarang : Boolean = false
) : Parcelable