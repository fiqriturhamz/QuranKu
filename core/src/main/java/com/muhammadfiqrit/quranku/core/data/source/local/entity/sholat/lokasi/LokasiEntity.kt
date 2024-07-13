package com.muhammadfiqrit.quranku.core.data.source.local.entity.sholat.lokasi

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lokasi")
data class LokasiEntity(
    @PrimaryKey

    @ColumnInfo(name = "idLokasi")
    val idLokasi: String,
    @ColumnInfo(name = "namaLokasi")
    val namaLokasi: String,
    @ColumnInfo(name = "lokasiSekarang")
    var lokasiSekarang: Boolean = false
)
