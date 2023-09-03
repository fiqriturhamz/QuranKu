package com.muhammadfiqrit.quranku.data.source.local

import androidx.lifecycle.LiveData
import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.local.room.SuratDao
import kotlinx.coroutines.flow.Flow


class LocalDataSource private constructor(private val suratDao: SuratDao) {
    companion object {
        private var instance: LocalDataSource? = null
        fun getInstance(suratDao: SuratDao): LocalDataSource = instance ?: synchronized(this) {
            instance ?: LocalDataSource(suratDao)
        }
    }

    fun getAllSurat(): Flow<List<SuratEntity>> = suratDao.getAllSurat()
    suspend fun insertSurat(suratList: List<SuratEntity>) = suratDao.insertSurat(suratList)
}