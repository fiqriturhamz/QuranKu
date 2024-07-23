package com.muhammadfiqrit.quranku.core.data.source.local.room.hadits

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muhammadfiqrit.quranku.core.data.source.local.entity.hadits.HaditsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HaditsDao {
    @Query("SELECT * FROM hadits")
    fun getAllHaditsArbain(): Flow<List<HaditsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllHaditsArbain(insert : List<HaditsEntity>)
}