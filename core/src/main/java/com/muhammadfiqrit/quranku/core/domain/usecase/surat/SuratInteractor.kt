package com.muhammadfiqrit.quranku.core.domain.usecase.surat

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirEntity
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.core.domain.model.detail.AyatWithSurat
import com.muhammadfiqrit.quranku.core.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.core.domain.model.detail.TafsirWithSurat
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.Tafsir
import com.muhammadfiqrit.quranku.core.domain.repository.ISuratRepository
import kotlinx.coroutines.flow.Flow

class SuratInteractor(private val suratRepository: ISuratRepository) : SuratUseCase {
    override fun getAllSurat(): Flow<Resource<List<Surat>>> {
        return suratRepository.getAllSurat()
    }
    override fun getSuratByNomor(nomorSurat: Int): Flow<Resource<DetailSurat>> {
        return suratRepository.getSuratByNomor(nomorSurat)
    }

    override fun getTafsir(nomorSurat: Int): Flow<Resource<DetailSurat>> {
        return suratRepository.getTafsir(nomorSurat)
    }

    override fun getFavoriteSurat(): Flow<List<Surat>> = suratRepository.getFavoriteSurat()
    override fun setFavoriteSurat(surat: DetailSurat, state: Boolean) =
        suratRepository.setFavoriteSurat(surat, state)
    override fun setAyatTerakhirDibaca(ayat: Ayat, state: Boolean) {
        suratRepository.setAyatTerakhirDibaca(ayat, state)
    }
    override fun getAyatWithSurat(): Flow<AyatWithSurat> {
        return suratRepository.getAyatWithSurat()
    }

    override fun setTafsirTerakhirDibaca(tafsir: Tafsir, state: Boolean) {
        suratRepository.setTafsirTerakhirDibaca(tafsir, state)
    }

    override fun getTafsirWithSurat(): Flow<TafsirWithSurat> {
        return suratRepository.getTafsirWithSurat()
    }

}