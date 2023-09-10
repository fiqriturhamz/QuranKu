package com.muhammadfiqrit.quranku.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.data.SuratRepository
import com.muhammadfiqrit.quranku.domain.usecase.SuratUseCase

class FavoriteViewModel(suratUseCase: SuratUseCase) : ViewModel() {
    val favoriteSurat = suratUseCase.getFavoriteSurat().asLiveData()
}