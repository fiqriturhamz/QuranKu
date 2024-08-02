package com.muhammadfiqrit.quranku.core.data.source.local.room.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muhammadfiqrit.quranku.core.data.source.local.entity.doa.DoaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DoaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDoa(insert: List<DoaEntity>)

    @Query("SELECT * FROM doa")
    fun getAllDoa(): Flow<List<DoaEntity>>
}