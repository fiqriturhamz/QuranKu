package com.muhammadfiqrit.quranku.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface SuratDao {
    @Query("SELECT * FROM surat")
    fun getAllSurat() : Flow<List<SuratEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurat(surat: List<SuratEntity>)

}