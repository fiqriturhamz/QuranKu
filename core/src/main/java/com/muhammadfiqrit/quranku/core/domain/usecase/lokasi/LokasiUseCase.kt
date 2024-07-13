package com.muhammadfiqrit.quranku.core.domain.usecase.lokasi

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.lokasi.Lokasi
import kotlinx.coroutines.flow.Flow

interface LokasiUseCase {
    fun getSemuaLokasi(): Flow<Resource<List<Lokasi>>>
    fun getLokasiSekarang() : Flow<Lokasi>
    fun setLokasiSekarang(lokasi : Lokasi, state:Boolean)
}