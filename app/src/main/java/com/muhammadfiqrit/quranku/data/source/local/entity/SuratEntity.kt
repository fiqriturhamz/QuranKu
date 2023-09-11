package com.muhammadfiqrit.quranku.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.AyatResponse

@Entity(tableName = "surat")
data class SuratEntity(
    @PrimaryKey
    val nomor: Int,
    val nama: String,
    val namaLatin: String,
    val jumlahAyat: Int,
    val tempatTurun: String,
    val arti: String,
    val deskripsi: String,
    var isFavorite : Boolean = false
)
