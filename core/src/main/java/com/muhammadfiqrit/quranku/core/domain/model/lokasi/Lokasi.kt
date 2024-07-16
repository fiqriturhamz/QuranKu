package com.muhammadfiqrit.quranku.core.domain.model.lokasi

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Lokasi(
    val idLokasi: String,
    val namaLokasi: String,
    val lokasiSekarang : Boolean
) : Parcelable