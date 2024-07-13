package com.muhammadfiqrit.quranku.core.data.source.local.entity.detail

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.muhammadfiqrit.quranku.core.data.source.local.entity.surat.SuratEntity


@Entity(
    tableName = "surat_selanjutnya",
    foreignKeys = [ForeignKey(
        entity = SuratEntity::class,
        parentColumns = ["nomor"],
        childColumns = ["nomorSurat"],
        onDelete = ForeignKey.CASCADE
    )]
)

data class SuratSelanjutnyaEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "nomor")
    val nomor: Int,
    @ColumnInfo(name = "nomorSurat")
    val nomorSurat: Int,
    @ColumnInfo(name = "nama")
    val nama: String,
    @ColumnInfo(name = "namaLatin")
    val namaLatin: String,
    @ColumnInfo(name = "jumlahAyat")
    val jumlahAyat: Int
)
