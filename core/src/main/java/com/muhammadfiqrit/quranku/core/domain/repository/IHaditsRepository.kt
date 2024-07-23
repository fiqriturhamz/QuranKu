package com.muhammadfiqrit.quranku.core.domain.repository

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.hadits.Hadits
import kotlinx.coroutines.flow.Flow

interface IHaditsRepository {
    fun getAllHaditsArbain() : Flow<Resource<List<Hadits>>>
}