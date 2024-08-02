package com.muhammadfiqrit.quranku.core.data.source.local

import com.muhammadfiqrit.quranku.core.data.source.local.entity.doa.DoaEntity
import com.muhammadfiqrit.quranku.core.data.source.local.room.doa.DoaDao
import kotlinx.coroutines.flow.Flow

class DoaLocalDataSource(private val doaDao: DoaDao) {
    suspend fun insertDoa(insert: List<DoaEntity>) = doaDao.insertDoa(insert)
    fun getAllDoa(): Flow<List<DoaEntity>> = doaDao.getAllDoa()
}