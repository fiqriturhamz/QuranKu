package com.muhammadfiqrit.quranku.domain.usecase

import com.muhammadfiqrit.quranku.data.Resource
import com.muhammadfiqrit.quranku.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.domain.model.surat.Surat
import kotlinx.coroutines.flow.Flow

interface SuratUseCase {
    fun getAllSurat() : Flow<Resource<List<Surat>>>
    fun getSuratByNomor(nomorSurat :Int) : Flow<Resource<DetailSurat>>
}