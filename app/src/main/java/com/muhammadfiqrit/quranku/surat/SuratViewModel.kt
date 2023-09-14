package com.muhammadfiqrit.quranku.surat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.data.SuratRepository
import com.muhammadfiqrit.quranku.core.domain.usecase.SuratUseCase

class SuratViewModel(suratUseCase: SuratUseCase) : ViewModel() {
    val surat = suratUseCase.getAllSurat().asLiveData()
}