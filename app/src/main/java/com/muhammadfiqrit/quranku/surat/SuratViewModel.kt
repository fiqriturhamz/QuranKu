package com.muhammadfiqrit.quranku.surat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratUseCase

class SuratViewModel(private val suratUseCase: SuratUseCase) : ViewModel() {
    val surat = suratUseCase.getAllSurat().asLiveData()
}