package com.muhammadfiqrit.quranku.domain.usecase

import com.muhammadfiqrit.quranku.domain.repository.ISuratRepository
import kotlinx.coroutines.flow.Flow

class SuratInteractor(private val suratRepository: ISuratRepository) : SuratUseCase {
    override fun getAllSurat() = suratRepository.getAllSurat()
    override fun getSuratByNomor(nomorSurat: Int) =
        suratRepository.getSuratByNomor(nomorSurat = nomorSurat)
}