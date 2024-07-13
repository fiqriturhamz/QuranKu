package com.muhammadfiqrit.quranku.core.data.source.local.room.sholat.lokasi

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.muhammadfiqrit.quranku.core.data.source.local.entity.sholat.lokasi.LokasiEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LokasiDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLokasi(lokasi: List<LokasiEntity>)

    @Query("SELECT * FROM lokasi")
    fun getAllLokasi(): Flow<List<LokasiEntity>>

    @Query("SELECT * FROM lokasi where lokasiSekarang = 1")
    fun getLokasiSekarang(): Flow<LokasiEntity>

    @Update
    fun updateLokasiSekarang(lokasi: LokasiEntity)

    @Query("UPDATE lokasi set lokasiSekarang = 0  WHERE lokasiSekarang = 1 ")
     fun resetAllLokasiSekarang()
}