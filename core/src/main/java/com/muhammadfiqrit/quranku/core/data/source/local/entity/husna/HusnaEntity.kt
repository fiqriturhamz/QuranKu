package com.muhammadfiqrit.quranku.core.data.source.local.entity.husna

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "husna")
data class HusnaEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "teksArab")
    val teksArab: String,
    @ColumnInfo(name = "teksIndo")
    val teksIndo: String,
    @ColumnInfo(name = "teksLatin")
    val teksLatin: String

)
