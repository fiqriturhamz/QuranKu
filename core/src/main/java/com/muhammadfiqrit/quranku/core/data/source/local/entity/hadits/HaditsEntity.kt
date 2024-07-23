package com.muhammadfiqrit.quranku.core.data.source.local.entity.hadits

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hadits")
data class HaditsEntity(
    @PrimaryKey
    @ColumnInfo("nomorHadits")
    val nomorHadits: String,
    @ColumnInfo("judulHadits")
    val judulHadits: String,
    @ColumnInfo("teksArab")
    val teksArab: String,
    @ColumnInfo("teksIndo")
    val teksIndo: String
)
