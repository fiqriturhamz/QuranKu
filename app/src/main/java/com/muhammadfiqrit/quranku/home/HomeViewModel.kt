package com.muhammadfiqrit.quranku.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.domain.usecase.sholat.SholatUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf

class HomeViewModel(private val sholatUseCase: SholatUseCase) : ViewModel() {
    private val _tanggal = MutableStateFlow<String?>(null)
    private val _idKota = MutableStateFlow<Int?>(null)
    /*   val jadwalSholatHarian =
           Transformations.switchMap(_tanggal) { tanggal ->
               Transformations.switchMap(_idKota) { idKota ->
                   sholatUseCase.getJadwalSholatPerHari(tanggal = tanggal, idKota = idKota)
                       .asLiveData()
               }
           }*/

    val jadwalSholatHarian = combine(_tanggal, _idKota) { tanggal, idKota ->
        Pair(tanggal, idKota)
    }.flatMapLatest { (tanggal, idKota) ->
        if (tanggal != null && idKota != null) {
            sholatUseCase.getJadwalSholatPerHari(
                tanggal = tanggal, idKota = idKota
            )
        } else {
            flowOf(null)
        }
    }.asLiveData()

    fun setTanggal(tanggal: String) {
        if (_tanggal.value == tanggal) return
        _tanggal.value = tanggal
    }

    fun setIdKota(idKota: Int) {
        if (_idKota.value == idKota) return
        _idKota.value = idKota
    }
}