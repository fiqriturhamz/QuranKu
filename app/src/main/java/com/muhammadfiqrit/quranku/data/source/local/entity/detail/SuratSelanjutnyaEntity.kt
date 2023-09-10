package com.muhammadfiqrit.quranku.data.source.local.entity.detail

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "surat_selanjutnya")
data class SuratSelanjutnyaEntity(
    @PrimaryKey
    @ColumnInfo(name = "nomor")
    val nomor: Int,
    @ColumnInfo(name = "nama")
    val nama: String,
    @ColumnInfo(name = "namaLatin")
    val namaLatin: String,
    @ColumnInfo(name = "jumlahAyat")
    val jumlahAyat: Int
)
