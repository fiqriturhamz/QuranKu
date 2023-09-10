package com.muhammadfiqrit.quranku.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.local.entity.detail.AyatEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface SuratDao {

    //Metode untuk entitas SuratEntity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurat(surat: List<SuratEntity>)

    @Query("SELECT * FROM surat")
    fun getAllSurat(): Flow<List<SuratEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailSurat(surat : SuratEntity)

    @Query("SELECT * FROM surat WHERE nomor = :nomorSurat")
    fun getSuratByNomor(nomorSurat: Int): Flow<SuratEntity>

 /*   @Query("SELECT * FROM ayat WHERE nomorSurat = :nomorSurat")
    fun getAyatBySurat(nomorSurat : Int) : List<AyatEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAyat(ayat: AyatEntity)*/


}