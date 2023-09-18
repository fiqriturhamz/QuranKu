package com.muhammadfiqrit.quranku.core.domain.repository

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.sholat.jadwal.JadwalDataHarian
import kotlinx.coroutines.flow.Flow

interface ISholatRepository {
    fun getJadwalSholatPerHari(tanggal : String, idKota : Int) : Flow<Resource<JadwalDataHarian>>
}