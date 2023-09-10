package com.muhammadfiqrit.quranku.data.source.local

import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.data.source.local.room.SuratDao
import com.muhammadfiqrit.quranku.domain.model.surat.Surat
import kotlinx.coroutines.flow.Flow


class LocalDataSource(private val suratDao: SuratDao) {

    //Surat
    suspend fun insertSurat(suratList: List<SuratEntity>) = suratDao.insertSurat(suratList)
    fun getAllSurat(): Flow<List<SuratEntity>> = suratDao.getAllSurat()

    fun getFavoriteSurat(): Flow<List<SuratEntity>> = suratDao.getFavoriteSurat()
    fun setFavoriteSurat(surat: SuratEntity, newState: Boolean) {
        surat.isFavorite = newState
        suratDao.updateFavoriteSurat(surat)
    }

    fun getSuratByNomor(nomorSurat: Int): Flow<SuratEntity> = suratDao.getSuratByNomor(nomorSurat)

    suspend fun insertDetailSurat(surat: SuratEntity) = suratDao.insertDetailSurat(surat)

    suspend fun insertAyat(ayat: List<AyatEntity>) = suratDao.insertAyat(ayat)
    fun getAyatBySurat(nomorSurat: Int) = suratDao.getAyatBySurat(nomorSurat)


}