package com.muhammadfiqrit.quranku.core.domain.usecase.hadits

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.hadits.Hadits
import com.muhammadfiqrit.quranku.core.domain.repository.IHaditsRepository
import kotlinx.coroutines.flow.Flow

class HaditsInteractor(private val iHaditsRepository: IHaditsRepository) : HaditsUseCase {
    override fun getAllHaditsArbain(): Flow<Resource<List<Hadits>>>{
        return iHaditsRepository.getAllHaditsArbain()
    }
}