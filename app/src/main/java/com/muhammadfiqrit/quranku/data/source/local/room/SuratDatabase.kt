package com.muhammadfiqrit.quranku.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity

@Database(entities = [SuratEntity::class], version = 1, exportSchema = false)
abstract class SuratDatabase : RoomDatabase() {
    abstract fun suratDao(): SuratDao
}