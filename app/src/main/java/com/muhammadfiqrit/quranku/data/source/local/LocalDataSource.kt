package com.muhammadfiqrit.quranku.data.source.local

import androidx.lifecycle.LiveData
import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.local.room.SuratDao

class LocalDataSource private constructor(private val suratDao: SuratDao) {
    companion object {
        private var instance: LocalDataSource? = null
        fun getInstance(suratDao: SuratDao): LocalDataSource = instance ?: synchronized(this) {
            instance ?: LocalDataSource(suratDao)
        }
    }

    fun getAllSurat(): LiveData<List<SuratEntity>> = suratDao.getAllSurat()
    fun insertSurat(suratList: List<SuratEntity>) = suratDao.insertSurat(suratList)
}