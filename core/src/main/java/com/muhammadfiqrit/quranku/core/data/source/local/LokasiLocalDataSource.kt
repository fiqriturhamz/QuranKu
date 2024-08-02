package com.muhammadfiqrit.quranku.core.data.source.local

import com.muhammadfiqrit.quranku.core.data.source.local.entity.sholat.lokasi.LokasiEntity
import com.muhammadfiqrit.quranku.core.data.source.local.room.sholat.lokasi.LokasiDao
import com.muhammadfiqrit.quranku.core.domain.model.lokasi.Lokasi
import kotlinx.coroutines.flow.Flow


class LokasiLocalDataSource(private val lokasiDao: LokasiDao) {
    suspend fun insertLokasi(lokasiList: List<LokasiEntity>) = lokasiDao.insertLokasi(lokasiList)
    fun getAllLokasi(): Flow<List<LokasiEntity>> = lokasiDao.getAllLokasi()
    fun getLokasiSekarang(): Flow<LokasiEntity> = lokasiDao.getLokasiSekarang()
    fun setLokasiSekarang(lokasi: LokasiEntity, newState: Boolean) {
        lokasiDao.resetAllLokasiSekarang()
        lokasi.lokasiSekarang = newState
        lokasiDao.updateLokasiSekarang(lokasi)
    }
}