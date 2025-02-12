package com.muhammadfiqrit.quranku.core.data.source.local.entity.surat


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat


@Entity(
    tableName = "surat",
    primaryKeys = ["nomor"]
)
data class SuratEntity(
    @ColumnInfo(name = "nomor")
    val nomor: Int,
    @ColumnInfo(name = "nama")
    val nama: String,
    @ColumnInfo(name = "namaLatin")
    val namaLatin: String,
    @ColumnInfo(name = "jumlahAyat")
    val jumlahAyat: Int,
    @ColumnInfo(name = "tempatTurun")
    val tempatTurun: String,
    @ColumnInfo(name = "arti")
    val arti: String,
    @ColumnInfo(name = "deskripsi")
    val deskripsi: String,
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean,
)