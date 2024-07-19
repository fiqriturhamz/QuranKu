package com.muhammadfiqrit.quranku.core.data.source.local.room.husna

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.muhammadfiqrit.quranku.core.data.source.local.entity.husna.HusnaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HusnaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllAsmaulHusna(insert: List<HusnaEntity>)

    @Query("SELECT * FROM husna")
    fun getAllAsmaulHusna(): Flow<List<HusnaEntity>>


}