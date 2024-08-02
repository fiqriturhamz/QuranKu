package com.muhammadfiqrit.quranku.core.domain.usecase.doa

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.doa.Doa
import kotlinx.coroutines.flow.Flow

interface DoaUseCase {
    fun getAllDoaByKeyword(keyword : String) : Flow<Resource<List<Doa>>?>
}