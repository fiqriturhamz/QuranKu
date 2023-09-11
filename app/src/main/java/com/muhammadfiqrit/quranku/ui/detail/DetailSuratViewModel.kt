package com.muhammadfiqrit.quranku.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.domain.usecase.SuratUseCase

class DetailSuratViewModel(private val suratUseCase: SuratUseCase) : ViewModel() {
    private val suratId = MutableLiveData<Int>()


    val suratDetail = Transformations.switchMap(suratId) {
        suratUseCase.getSuratByNomor(it).asLiveData()

    }

 /*   val ayatDetail = Transformations.switchMap(suratId) {
        suratUseCase.getAyatBySurat(it).asLiveData()
    }*/

    fun setId(id: Int) {
        if (suratId.value == id) return
        suratId.value = id
    }

    fun setFavoriteSurat(surat: DetailSurat, newStatus: Boolean) =
        suratUseCase.setFavoriteSurat(surat, newStatus)

}