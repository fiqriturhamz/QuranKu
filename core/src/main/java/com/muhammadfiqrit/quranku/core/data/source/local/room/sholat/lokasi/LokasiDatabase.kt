package com.muhammadfiqrit.quranku.core.data.source.local.room.sholat.lokasi

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muhammadfiqrit.quranku.core.data.source.local.entity.sholat.lokasi.LokasiEntity

@Database(entities = [LokasiEntity::class],
    version = 1,
    exportSchema = false)
abstract class LokasiDatabase : RoomDatabase() {
    abstract fun lokasiDao(): LokasiDao
}