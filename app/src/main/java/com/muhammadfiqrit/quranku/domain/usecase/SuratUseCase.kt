package com.muhammadfiqrit.quranku.domain.usecase

import androidx.lifecycle.LiveData
import com.muhammadfiqrit.quranku.data.Resource
import com.muhammadfiqrit.quranku.domain.model.Surat

interface SuratUseCase {
    fun getAllSurat() : LiveData<Resource<List<Surat>>>
}