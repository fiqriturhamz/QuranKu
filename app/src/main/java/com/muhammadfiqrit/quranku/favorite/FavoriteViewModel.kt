package com.muhammadfiqrit.quranku.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.data.SuratRepository
import com.muhammadfiqrit.quranku.core.domain.usecase.SuratUseCase

class FavoriteViewModel(suratUseCase: SuratUseCase) : ViewModel() {
    val favoriteSurat = suratUseCase.getFavoriteSurat().asLiveData()
}