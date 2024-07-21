package com.muhammadfiqrit.quranku.husna

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.domain.usecase.husna.HusnaUseCase

class HusnaViewModel(private val husnaUseCase: HusnaUseCase) : ViewModel() {
    val getAllHusna = husnaUseCase.getAllAsmaulHusna().asLiveData()
}