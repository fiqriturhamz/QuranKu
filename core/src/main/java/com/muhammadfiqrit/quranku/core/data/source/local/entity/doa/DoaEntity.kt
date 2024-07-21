package com.muhammadfiqrit.quranku.core.data.source.local.entity.doa

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doa")
data class DoaEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? ,
    @ColumnInfo(name = "teksArab")
    val teksArab: String,
    @ColumnInfo(name = "teksIndo")
    val teksIndo: String,
    @ColumnInfo(name = "judul")
    val judul: String,
    @ColumnInfo(name = "source")
    val source: String
)
