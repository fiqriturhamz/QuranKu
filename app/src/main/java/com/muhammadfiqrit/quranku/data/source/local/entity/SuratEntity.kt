package com.muhammadfiqrit.quranku.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.AyatResponse

@Entity(tableName = "surat")
data class SuratEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nomor")
    var nomor: Int,

    @ColumnInfo(name = "nama")
    var nama: String,

    @ColumnInfo(name = "jumlahAyat")
    var jumlahAyat: Int,

    @ColumnInfo("tempatTurun")
    var tempatTurun: String,

    @ColumnInfo("arti")
    var arti: String,

    @ColumnInfo("deskripsi")
    var deskripsi: String,

    @ColumnInfo("namaLatin")
    var namaLatin: String,


    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
