package com.muhammadfiqrit.quranku.detail


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.Tafsir
import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class DetailSuratViewModel(private val suratUseCase: SuratUseCase) : ViewModel() {
    private val suratId = MutableStateFlow<Int?>(null)
    fun setAyatTerakhirDibaca(ayat: Ayat, state: Boolean) {
        viewModelScope.launch {
            try {
                Log.d("AyatViewModel", "Setting Ayat: $ayat, newState: $state")
                suratUseCase.setAyatTerakhirDibaca(ayat, state)
            } catch (e: Exception) {
                Log.e("AyatViewModel", "Error setting Ayat", e)
            }
        }
    }

    fun setTafsirTerakhirDibaca(tafsir: Tafsir, state: Boolean) {
        viewModelScope.launch {
            try {
                suratUseCase.setTafsirTerakhirDibaca(tafsir, state)
            } catch (e: Exception) {
                Log.e("DetailSuratViewModel", e.message.toString())
            }
        }
    }

    val ayatWithSurat = suratUseCase.getAyatWithSurat().asLiveData()
    val tafsirWithSurat = suratUseCase.getTafsirWithSurat().asLiveData()


    val suratDetail = suratId.flatMapLatest { id ->
        id?.let { suratUseCase.getSuratByNomor(it) } ?: flow { emit(null) }
    }.asLiveData()


    fun setId(id: Int) {
        if (suratId.value == id) return
        viewModelScope.launch {
            suratId.value = id
            // Jika ada operasi tambahan, letakkan di sini
        }
    }


}