package com.muhammadfiqrit.quranku.core.data.source.local.room.doa

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muhammadfiqrit.quranku.core.data.source.local.entity.HusnaEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.doa.DoaEntity
import com.muhammadfiqrit.quranku.core.data.source.local.room.husna.HusnaDao
import com.muhammadfiqrit.quranku.core.domain.model.doa.Doa
import kotlinx.coroutines.flow.Flow

@Database(entities = [DoaEntity::class, HusnaEntity::class], version = 1, exportSchema = false)
abstract class DoaDatabase : RoomDatabase() {
    abstract fun doaDao(): HusnaDao
}