package com.muhammadfiqrit.quranku.core.data.source.local

import com.muhammadfiqrit.quranku.core.data.source.local.entity.surat.SuratEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.SuratSelanjutnyaEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirEntity
import com.muhammadfiqrit.quranku.core.data.source.local.room.surat.SuratDao
import kotlinx.coroutines.flow.Flow


class SuratLocalDataSource(private val suratDao: SuratDao) {

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

    suspend fun insertSuratSelanjutnya(suratSelanjutnya: SuratSelanjutnyaEntity) =
        suratDao.insertSuratSelanjutnya(suratSelanjutnya)

    fun getSuratSelanjutnya(nomorSurat: Int) = suratDao.getSuratSelanjutnya(nomorSurat)


    suspend fun insertTafsir(listTafsir: List<TafsirEntity>) = suratDao.insertTafsir(listTafsir)
    fun getTafsir(nomorSurat: Int): Flow<List<TafsirEntity>> = suratDao.getTafsir(nomorSurat)


}