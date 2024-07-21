package com.muhammadfiqrit.quranku.core.data.source.local.room.husna

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muhammadfiqrit.quranku.core.data.source.local.entity.HusnaEntity


@Database(entities = [HusnaEntity::class], version = 1, exportSchema = false)
abstract class HusnaDatabase : RoomDatabase() {
    abstract fun asmaulHusnaDao(): HusnaDao

}