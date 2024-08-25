package com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.muhammadfiqrit.quranku.core.data.source.local.entity.surat.SuratEntity
import dalvik.system.DelegateLastClassLoader

@Entity(
    tableName = "tafsir",
    foreignKeys = [ForeignKey(
        entity = SuratEntity::class,
        parentColumns = ["nomor"],
        childColumns = ["nomorSurat"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class TafsirEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id: Long = 0,
    @ColumnInfo(name = "ayat")
    var ayat: Int,
    @ColumnInfo(name = "nomorSurat")
    var nomorSurat: Int,
    @ColumnInfo(name = "teks")
    var teks: String,
    @ColumnInfo("isLastRead")
    var isLastRead: Boolean = false
)
