package com.muhammadfiqrit.quranku.core.domain.usecase.husna

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.husna.Husna
import kotlinx.coroutines.flow.Flow

interface HusnaUseCase {
    fun getAllAsmaulHusna () : Flow<Resource<List<Husna>>>
}