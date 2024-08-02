package com.muhammadfiqrit.quranku.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratUseCase

class FavoriteViewModel( private val suratUseCase: SuratUseCase) : ViewModel() {
    val favoriteSurat = suratUseCase.getFavoriteSurat().asLiveData()
    fun setFavoriteSurat(surat: DetailSurat, newStatus: Boolean) =
        suratUseCase.setFavoriteSurat(surat, newStatus)
}