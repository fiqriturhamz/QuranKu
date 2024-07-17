package com.muhammadfiqrit.quranku.detail.tafsir

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratUseCase

class TafsirViewModel(private val suratUsecase: SuratUseCase) : ViewModel() {

    private val suratId = MutableLiveData<Int>()
    val suratDetail = Transformations.switchMap(suratId) {
        suratUsecase.getTafsir(it).asLiveData()
    }

    fun setId(nomorSurat: Int) {
        if (suratId.value == nomorSurat) return
        suratId.value = nomorSurat
    }
}