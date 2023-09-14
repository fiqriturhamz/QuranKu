package com.muhammadfiqrit.quranku.core.domain.usecase

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.core.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.core.domain.repository.ISuratRepository
import kotlinx.coroutines.flow.Flow

class SuratInteractor(private val suratRepository: ISuratRepository) : SuratUseCase {
    override fun getAllSurat() = suratRepository.getAllSurat()
    override fun getSuratByNomor(nomorSurat: Int) =
        suratRepository.getSuratByNomor(nomorSurat = nomorSurat)

    override fun getFavoriteSurat(): Flow<List<Surat>> = suratRepository.getFavoriteSurat()

    override fun setFavoriteSurat(surat: DetailSurat, state: Boolean) =
        suratRepository.setFavoriteSurat(surat, state)
}