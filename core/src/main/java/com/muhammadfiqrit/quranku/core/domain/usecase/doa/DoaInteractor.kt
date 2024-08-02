package com.muhammadfiqrit.quranku.core.domain.usecase.doa

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.doa.Doa
import com.muhammadfiqrit.quranku.core.domain.repository.IDoaRepository
import kotlinx.coroutines.flow.Flow

class DoaInteractor(private val iDoaRepository: IDoaRepository) : DoaUseCase {
    override fun getAllDoaByKeyword(keyword:String): Flow<Resource<List<Doa>>> {
      return  iDoaRepository.getAllDoa(keyword)
    }
}