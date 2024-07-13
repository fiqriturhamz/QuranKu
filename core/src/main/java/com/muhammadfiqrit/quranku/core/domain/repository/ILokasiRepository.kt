package com.muhammadfiqrit.quranku.core.domain.repository

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.lokasi.Lokasi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface ILokasiRepository {
    fun getSemuaLokasi(): Flow<Resource<List<Lokasi>>>
    fun getLokasiSekarang(): Flow<Lokasi>
    fun setLokasiSekarang(lokasi: Lokasi, state: Boolean)
}