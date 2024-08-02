package com.muhammadfiqrit.quranku.core.domain.usecase.husna

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.husna.Husna
import com.muhammadfiqrit.quranku.core.domain.repository.IHusnaRepository
import kotlinx.coroutines.flow.Flow

class HusnaInteractor(private val husnaRepository: IHusnaRepository) : HusnaUseCase {
    override fun getAllAsmaulHusna(): Flow<Resource<List<Husna>>> {
        return husnaRepository.getAllAsmaulHusna()
    }
}