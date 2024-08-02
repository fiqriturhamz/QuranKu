package com.muhammadfiqrit.quranku.core.domain.repository

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.doa.Doa
import kotlinx.coroutines.flow.Flow

interface IDoaRepository {
    fun getAllDoa(keyword: String) : Flow<Resource<List<Doa>>>
}