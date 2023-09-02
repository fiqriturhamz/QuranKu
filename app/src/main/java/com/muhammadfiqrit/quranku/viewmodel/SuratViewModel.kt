package com.muhammadfiqrit.quranku.viewmodel

import androidx.lifecycle.ViewModel
import com.muhammadfiqrit.quranku.data.SuratRepository

class SuratViewModel(suratRepository: SuratRepository) : ViewModel() {
    val surat = suratRepository.getAllSurat()
}