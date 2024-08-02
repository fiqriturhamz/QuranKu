package com.muhammadfiqrit.quranku.hadits

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.domain.usecase.hadits.HaditsUseCase

class HaditsViewModel(private val haditsUseCase: HaditsUseCase) : ViewModel() {
    fun getAllHadits() = haditsUseCase.getAllHaditsArbain().asLiveData()
}