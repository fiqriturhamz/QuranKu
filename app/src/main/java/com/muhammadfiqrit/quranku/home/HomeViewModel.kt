package com.muhammadfiqrit.quranku.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.domain.usecase.sholat.SholatUseCase

class HomeViewModel(private val sholatUseCase: SholatUseCase) : ViewModel() {
    private val _tanggal = MutableLiveData<String>()
    private val _idKota = MutableLiveData<Int>()
    val jadwalSholatHarian =
        Transformations.switchMap(_tanggal) { tanggal ->
            Transformations.switchMap(_idKota) { idKota ->
                sholatUseCase.getJadwalSholatPerHari(tanggal = tanggal, idKota = idKota)
                    .asLiveData()
            }
        }

    fun setTanggal(tanggal: String) {
        if (_tanggal.value == tanggal) return
        _tanggal.value = tanggal
    }

    fun setIdKota(idKota: Int) {
        if (_idKota.value == idKota) return
        _idKota.value = idKota
    }
}