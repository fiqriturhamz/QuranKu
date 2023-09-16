package com.muhammadfiqrit.quranku.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muhammadfiqrit.quranku.core.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.SuratSelanjutnyaEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirEntity

@Database(entities = [SuratEntity::class, AyatEntity::class, SuratSelanjutnyaEntity::class, TafsirEntity::class], version = 1, exportSchema = false)
abstract class SuratDatabase : RoomDatabase() {
    abstract fun suratDao(): SuratDao
}