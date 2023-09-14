package com.muhammadfiqrit.quranku.core.data.source.local.entity.detail

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.muhammadfiqrit.quranku.core.data.source.local.entity.SuratEntity


@Entity(
    tableName = "ayat",
    foreignKeys = [ForeignKey(
        entity = SuratEntity::class,
        parentColumns = ["nomor"],
        childColumns = ["nomorSurat"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class AyatEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Long = 0,
    @ColumnInfo(name = "nomorAyat")
    val nomorAyat: Int,
    @ColumnInfo(name = "nomorSurat")
    var nomorSurat: Int,
    @ColumnInfo(name = "teksArab")
    var teksArab: String,
    @ColumnInfo(name = "teksLatin")
    var teksLatin: String,
    @ColumnInfo(name = "teksIndonesia")
    var teksIndonesia: String
)

