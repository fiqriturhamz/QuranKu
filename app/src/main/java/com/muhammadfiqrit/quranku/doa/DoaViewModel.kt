package com.muhammadfiqrit.quranku.doa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.domain.usecase.doa.DoaUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

class DoaViewModel(private val doaUseCase: DoaUseCase) : ViewModel() {
    private val _keyword = MutableStateFlow<String?>(null)
    val doa =
        _keyword.flatMapLatest { keyword ->
            keyword?.let { doaUseCase.getAllDoaByKeyword(it) } ?: flow { emit(null) }

        }.asLiveData()

    fun setKeyword(keyword: String) {
        if (_keyword.value == keyword) return
        _keyword.value = keyword
    }
}