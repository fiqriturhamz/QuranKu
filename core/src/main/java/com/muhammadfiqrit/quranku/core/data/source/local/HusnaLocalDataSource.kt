package com.muhammadfiqrit.quranku.core.data.source.local

import com.muhammadfiqrit.quranku.core.data.source.local.entity.husna.HusnaEntity
import com.muhammadfiqrit.quranku.core.data.source.local.room.husna.HusnaDao
import kotlinx.coroutines.flow.Flow

class HusnaLocalDataSource(private val husnaDao: HusnaDao) {
    fun getAllAsmaulHusna(): Flow<List<HusnaEntity>> {
        return husnaDao.getAllAsmaulHusna()
    }

    suspend fun insertHusna(insert: List<HusnaEntity>) = husnaDao.insertAllAsmaulHusna(insert)
}