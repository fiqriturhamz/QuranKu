package com.muhammadfiqrit.quranku.core.data.source.local

import com.muhammadfiqrit.quranku.core.data.source.local.entity.hadits.HaditsEntity
import com.muhammadfiqrit.quranku.core.data.source.local.room.hadits.HaditsDao
import kotlinx.coroutines.flow.Flow

class HaditsLocalDataSource(private val haditsDao: HaditsDao) {
    fun getAllHaditsArbain(): Flow<List<HaditsEntity>> = haditsDao.getAllHaditsArbain()
    suspend fun insertAllHaditsArbain(insert: List<HaditsEntity>) =
        haditsDao.insertAllHaditsArbain(insert)
}