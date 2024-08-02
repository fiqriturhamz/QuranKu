package com.muhammadfiqrit.quranku.detail


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

class DetailSuratViewModel(private val suratUseCase: SuratUseCase) : ViewModel() {
    private val suratId = MutableStateFlow<Int?>(null)

    /* val suratDetail = Transformations.switchMap(suratId) {
         suratUseCase.getSuratByNomor(it).asLiveData()

     }*/


    val suratDetail = suratId.flatMapLatest { id ->
        id?.let { suratUseCase.getSuratByNomor(it) } ?: flow { emit(null) }
    }.asLiveData()



    fun setId(id: Int) {
        if (suratId.value == id) return
        suratId.value = id
    }



}