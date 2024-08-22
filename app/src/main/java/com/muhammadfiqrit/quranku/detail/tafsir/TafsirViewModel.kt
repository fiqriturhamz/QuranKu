package com.muhammadfiqrit.quranku.detail.tafsir

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

class TafsirViewModel(private val suratUsecase: SuratUseCase) : ViewModel() {

    private val suratId = MutableStateFlow<Int?>(null)
    val suratDetail = suratId.flatMapLatest { id ->
        id?.let { suratUsecase.getTafsir(it) } ?: flow { emit(null) }
    }.asLiveData()

    fun setId(nomorSurat: Int) {
        if (suratId.value == nomorSurat) return
        suratId.value = nomorSurat
    }
}