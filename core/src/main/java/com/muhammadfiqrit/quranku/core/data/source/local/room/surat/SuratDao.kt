package com.muhammadfiqrit.quranku.core.data.source.local.room.surat

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.surat.SuratEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirEntity
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


    /*    //DETAIL SURAT
      @Insert(onConflict = OnConflictStrategy.REPLACE)
      suspend fun insertDetailSurat(surat: SuratEntity)*/

    /*  //



      //SURAT SELANJUTNYA
      @Insert(onConflict = OnConflictStrategy.REPLACE)
      suspend fun insertSuratSelanjutnya(suratSelanjutnya: SuratSelanjutnyaEntity)

      @Query("SELECT * FROM surat_selanjutnya WHERE nomorSurat = :nomorSurat ")
      fun getSuratSelanjutnya(nomorSurat: Int): Flow<SuratSelanjutnyaEntity>




      @Update
      fun updateAyatTerakhirDibaca(Ayat: AyatEntity)

      @Query("SELECT * FROM ayat WHERE isLastRead = 1")
      fun getAyatTerakhirDibaca(): Flow<AyatEntity>*/
}