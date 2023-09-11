package com.muhammadfiqrit.quranku.data.source.local.entity.detail

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity

@Entity(tableName = "ayat")
data class AyatEntity(
    @PrimaryKey
    val nomorAyat: Int,
    val teksArab: String,
    val teksLatin: String,
    val teksIndonesia: String,
    val suratNomor: Int // Kolom untuk menghubungkan ayat dengan surat
)
