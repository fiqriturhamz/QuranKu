package com.muhammadfiqrit.quranku.core.domain.repository

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.husna.Husna
import kotlinx.coroutines.flow.Flow

interface IHusnaRepository {
    fun getAllAsmaulHusna(): Flow<Resource<List<Husna>>>
}