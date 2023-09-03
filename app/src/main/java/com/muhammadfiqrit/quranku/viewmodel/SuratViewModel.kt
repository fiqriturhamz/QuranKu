package com.muhammadfiqrit.quranku.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.data.SuratRepository
import com.muhammadfiqrit.quranku.domain.usecase.SuratUseCase

class SuratViewModel(suratUseCase: SuratUseCase) : ViewModel() {
    val surat = suratUseCase.getAllSurat().asLiveData()
}