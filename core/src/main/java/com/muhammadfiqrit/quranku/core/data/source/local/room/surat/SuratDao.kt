package com.muhammadfiqrit.quranku.core.data.source.local.room.surat

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.AyatWithSuratEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.surat.SuratEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirWithSuratEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface SuratDao {

    //SURAT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurat(suratList: List<SuratEntity>)

    @Query("SELECT * FROM surat")
    fun getAllSurat(): Flow<List<SuratEntity>>

    @Query("SELECT * FROM surat WHERE nomor = :nomorSurat")
    fun getSuratByNomor(nomorSurat: Int): Flow<SuratEntity>

    // AYAT

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAyat(ayat: List<AyatEntity>)

    @Query("SELECT * FROM ayat WHERE nomorSurat = :nomorSurat")
    fun getAyatBySurat(nomorSurat: Int): Flow<List<AyatEntity>>


    //TAFSIR
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTafsir(tafsir: List<TafsirEntity>)

    @Query("SELECT * FROM tafsir WHERE nomorSurat = :nomorSurat ")
    fun getTafsir(nomorSurat: Int): Flow<List<TafsirEntity>>


    @Query("SELECT * FROM surat where isFavorite = 1")
    fun getFavoriteSurat(): Flow<List<SuratEntity>>

    @Update
    fun updateFavoriteSurat(surat: SuratEntity)

    @Query("UPDATE ayat SET isLastRead = :isLastRead WHERE id = :id")
    fun updateAyatTerakhirDibaca(id: Long, isLastRead: Boolean)

    @Query("UPDATE ayat set isLastRead =0 WHERE isLastRead = 1")
    fun resetAllAyatTerakhirDibaca()

    @Transaction
    @Query("SELECT * FROM ayat WHERE isLastRead = 1")
    fun getAyatWithSurat(): Flow<AyatWithSuratEntity>

    @Query("SELECT * FROM tafsir WHERE isLastRead = 1")
    fun getTafsirTerakhirDibaca(): Flow<TafsirEntity>

    @Query("UPDATE tafsir SET isLastRead = :isLastRead WHERE id = :id ")
    fun updateTafsirTerakhirDibaca(id: Long, isLastRead: Boolean)

    @Query("UPDATE tafsir set isLastRead =0 WHERE isLastRead = 1")
    fun resetAllTafsirTerakhirDibaca()

    @Transaction
    @Query("SELECT * FROM tafsir WHERE isLastRead = 1")
    fun getTafsirWithSurat(): Flow<TafsirWithSuratEntity>


}