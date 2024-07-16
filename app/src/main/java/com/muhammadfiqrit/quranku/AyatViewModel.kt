package com.muhammadfiqrit.quranku

import androidx.lifecycle.ViewModel
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratUseCase

class AyatViewModel(private val suratUseCase: SuratUseCase) : ViewModel() {

    val ayatTerakhirDibaca = suratUseCase.getAyatTerakhirDibaca()
    fun setAyatTerakhirDibaca(ayat: Ayat, state: Boolean) {
        suratUseCase.setAyatTerakhirDibaca(ayat, state)
    }
}