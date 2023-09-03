package com.muhammadfiqrit.quranku.domain.usecase

import androidx.lifecycle.LiveData
import com.muhammadfiqrit.quranku.data.Resource
import com.muhammadfiqrit.quranku.data.SuratRepository
import com.muhammadfiqrit.quranku.domain.model.Surat
import com.muhammadfiqrit.quranku.domain.repository.ISuratRepository
import kotlinx.coroutines.flow.Flow

class SuratInteractor(private val suratRepository: ISuratRepository): SuratUseCase  {
    override fun getAllSurat() = suratRepository.getAllSurat()
}