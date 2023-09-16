package com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tafsir")
data class TafsirEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "ayat")
    var ayat: Int,
    @ColumnInfo(name = "nomorSurat")
    var nomorSurat: Int,
    @ColumnInfo(name = "teks")
    var teks: String
)
