package com.muhammadfiqrit.quranku.core.data.source.local

import com.muhammadfiqrit.quranku.core.data.source.local.entity.surat.SuratEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.AyatWithSuratEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirWithSuratEntity
import com.muhammadfiqrit.quranku.core.data.source.local.room.surat.SuratDao
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.Tafsir
import kotlinx.coroutines.flow.Flow


class SuratLocalDataSource(private val suratDao: SuratDao) {

    //Surat
    suspend fun insertSurat(suratList: List<SuratEntity>) = suratDao.insertSurat(suratList)
    fun getAllSurat(): Flow<List<SuratEntity>> = suratDao.getAllSurat()
    fun getSuratByNomor(nomorSurat: Int): Flow<SuratEntity> = suratDao.getSuratByNomor(nomorSurat)
    suspend fun insertAyat(listAyat: List<AyatEntity>) = suratDao.insertAyat(listAyat)
    fun getAyatBySurat(nomorSurat: Int) = suratDao.getAyatBySurat(nomorSurat)

    suspend fun insertTafsir(listTafsir: List<TafsirEntity>) = suratDao.insertTafsir(listTafsir)
    fun getTafsirBySurat(nomorSurat: Int): Flow<List<TafsirEntity>> = suratDao.getTafsir(nomorSurat)


    fun getFavoriteSurat(): Flow<List<SuratEntity>> = suratDao.getFavoriteSurat()
    fun setFavoriteSurat(surat: SuratEntity, newState: Boolean) {
        surat.isFavorite = newState
        suratDao.updateFavoriteSurat(surat)
    }

    fun updateAyatTerakhirDibaca(id: Long, isLastRead: Boolean) {
        suratDao.resetAllAyatTerakhirDibaca()
        suratDao.updateAyatTerakhirDibaca(id, isLastRead)
    }

    fun getAyatWithSurat(): Flow<AyatWithSuratEntity> {
        return suratDao.getAyatWithSurat()
    }

    fun updateTafsirTerakhirDibaca(id: Long, isLastRead: Boolean) {
        suratDao.resetAllTafsirTerakhirDibaca()
        suratDao.updateTafsirTerakhirDibaca(id, isLastRead)
    }

    fun getTafsirWithSurat(): Flow<TafsirWithSuratEntity> {
        return suratDao.getTafsirWithSurat()
    }


    /*  suspend fun insertDetailSurat(surat: SuratEntity) = suratDao.insertDetailSurat(surat)*/


    /*
        fun getAyatTerakhirDibaca(): Flow<AyatEntity> = suratDao.getAyatTerakhirDibaca()
        fun setAyatTerakhirDibaca(ayat: AyatEntity, newState: Boolean) {
            ayat.isLastRead = newState
            suratDao.updateAyatTerakhirDibaca(ayat)
        }

        suspend fun insertSuratSelanjutnya(suratSelanjutnya: SuratSelanjutnyaEntity) =
            suratDao.insertSuratSelanjutnya(suratSelanjutnya)

        fun getSuratSelanjutnya(nomorSurat: Int) = suratDao.getSuratSelanjutnya(nomorSurat)



    */


}