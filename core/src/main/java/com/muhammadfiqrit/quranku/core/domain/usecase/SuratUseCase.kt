package com.muhammadfiqrit.quranku.core.domain.usecase

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.TafsirItem
import kotlinx.coroutines.flow.Flow

interface SuratUseCase {
    fun getAllSurat() : Flow<com.muhammadfiqrit.quranku.core.data.Resource<List<Surat>>>
    fun getSuratByNomor(nomorSurat :Int) : Flow<com.muhammadfiqrit.quranku.core.data.Resource<DetailSurat>>

    fun getFavoriteSurat() : Flow<List<Surat>>

    fun setFavoriteSurat(surat: DetailSurat, state:Boolean)

    fun getTafsir(nomorSurat: Int) : Flow<Resource<List<TafsirItem>>>
}