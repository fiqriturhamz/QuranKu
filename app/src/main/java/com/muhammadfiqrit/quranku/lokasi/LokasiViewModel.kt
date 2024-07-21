package com.muhammadfiqrit.quranku.lokasi


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.domain.model.lokasi.Lokasi
import com.muhammadfiqrit.quranku.core.domain.usecase.lokasi.LokasiUseCase

class LokasiViewModel(private val lokasiUseCase: LokasiUseCase) : ViewModel() {
    val lokasi = lokasiUseCase.getSemuaLokasi().asLiveData()
    val lokasiSekarang = lokasiUseCase.getLokasiSekarang().asLiveData()

    fun setLokasiSekarang(lokasi: Lokasi, newStatus: Boolean) =
        lokasiUseCase.setLokasiSekarang(lokasi, newStatus)
}