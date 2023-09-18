package com.muhammadfiqrit.quranku.core.domain.model.sholat.jadwal

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JadwalDataHarian(
    val lokasi: String,
    val daerah: String,
    val id: String,
    val imsak: String,
    val isya: String,
    val dzuhur: String,
    val subuh: String,
    val dhuha: String,
    val terbit: String,
    val tanggal: String,
    val ashar: String,
    val maghrib: String
): Parcelable
