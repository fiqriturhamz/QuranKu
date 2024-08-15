package com.muhammadfiqrit.quranku.detail


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.core.domain.model.detail.AyatWithSurat
import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailSuratViewModel(private val suratUseCase: SuratUseCase) : ViewModel() {
    private val suratId = MutableStateFlow<Int?>(null)

    val ayatTerakhirDibaca = suratUseCase.getAyatTerakhirDibaca().asLiveData()
    fun setAyatTerakhirDibaca(ayat: Ayat, state: Boolean) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Log.d("AyatViewModel", "Setting Ayat: $ayat, newState: $state")
                suratUseCase.setAyatTerakhirDibaca(ayat, state)
            }
        }

    }

    val ayatWithSurat = suratUseCase.getAyatWithSurat().asLiveData()


    val suratDetail = suratId.flatMapLatest { id ->
        id?.let { suratUseCase.getSuratByNomor(it) } ?: flow { emit(null) }
    }.asLiveData()


    fun setId(id: Int) {
        if (suratId.value == id) return
        suratId.value = id
    }


}