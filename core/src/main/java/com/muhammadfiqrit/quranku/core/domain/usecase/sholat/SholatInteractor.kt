package com.muhammadfiqrit.quranku.core.domain.usecase.sholat

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.sholat.jadwal.JadwalDataHarian
import com.muhammadfiqrit.quranku.core.domain.repository.ISholatRepository
import kotlinx.coroutines.flow.Flow

class SholatInteractor(private val sholatRepository: ISholatRepository) : SholatUseCase {
    override fun getJadwalSholatPerHari(
        tanggal: String,
        idKota: Int
    ): Flow<Resource<JadwalDataHarian>> {
        return sholatRepository.getJadwalSholatPerHari(tanggal, idKota)
    }
}