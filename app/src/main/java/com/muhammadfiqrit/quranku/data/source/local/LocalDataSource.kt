package com.muhammadfiqrit.quranku.data.source.local

import androidx.lifecycle.LiveData
import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.local.room.SuratDao
import kotlinx.coroutines.flow.Flow


class LocalDataSource(private val suratDao: SuratDao) {

    fun getAllSurat(): Flow<List<SuratEntity>> = suratDao.getAllSurat()
    suspend fun insertSurat(suratList: List<SuratEntity>) = suratDao.insertSurat(suratList)
}