package com.muhammadfiqrit.quranku.core.domain.usecase.sholat

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.sholat.jadwal.JadwalDataHarian
import kotlinx.coroutines.flow.Flow

interface SholatUseCase {
    fun getJadwalSholatPerHari(tanggal : String, idKota : Int) : Flow<Resource<JadwalDataHarian>>

}