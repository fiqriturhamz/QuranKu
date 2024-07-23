package com.muhammadfiqrit.quranku.core.data.source.local.room.hadits

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muhammadfiqrit.quranku.core.data.source.local.entity.hadits.HaditsEntity

@Database(entities = [HaditsEntity::class], version = 1, exportSchema = false)
abstract class HaditsDatabase() : RoomDatabase() {
    abstract fun haditsDao(): HaditsDao
}