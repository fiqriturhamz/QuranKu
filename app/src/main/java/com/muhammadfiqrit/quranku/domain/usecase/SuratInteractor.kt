package com.muhammadfiqrit.quranku.domain.usecase

import com.muhammadfiqrit.quranku.data.Resource
import com.muhammadfiqrit.quranku.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.domain.repository.ISuratRepository
import kotlinx.coroutines.flow.Flow

class SuratInteractor(private val suratRepository: ISuratRepository) : SuratUseCase {
    override fun getAllSurat() = suratRepository.getAllSurat()
    override fun getSuratByNomor(nomorSurat: Int) =
        suratRepository.getSuratByNomor(nomorSurat = nomorSurat)

    override fun getFavoriteSurat(): Flow<List<Surat>> = suratRepository.getFavoriteSurat()

    override fun setFavoriteSurat(surat: DetailSurat, state: Boolean) =
        suratRepository.setFavoriteSurat(surat, state)

    override fun getAyatBySurat(nomorSurat: Int): Flow<Resource<List<Ayat>>> =
        suratRepository.getAyatBySurat(nomorSurat)


}