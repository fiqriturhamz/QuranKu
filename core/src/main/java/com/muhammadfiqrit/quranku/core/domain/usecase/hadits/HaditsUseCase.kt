package com.muhammadfiqrit.quranku.core.domain.usecase.hadits

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.hadits.Hadits
import kotlinx.coroutines.flow.Flow

interface HaditsUseCase {
    fun getAllHaditsArbain() : Flow<Resource<List<Hadits>>>
}