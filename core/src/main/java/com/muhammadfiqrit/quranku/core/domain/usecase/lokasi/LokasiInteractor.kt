package com.muhammadfiqrit.quranku.core.domain.usecase.lokasi

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi.ResponseSemuaLokasi
import com.muhammadfiqrit.quranku.core.domain.model.lokasi.Lokasi
import com.muhammadfiqrit.quranku.core.domain.repository.ILokasiRepository
import kotlinx.coroutines.flow.Flow

class LokasiInteractor(private val lokasiRepository: ILokasiRepository) : LokasiUseCase {
    override fun getSemuaLokasi(): Flow<Resource<List<Lokasi>>> {
        return lokasiRepository.getSemuaLokasi()
    }

    override fun getLokasiSekarang(): Flow<Lokasi> = lokasiRepository.getLokasiSekarang()

    override fun setLokasiSekarang(lokasi: Lokasi, state: Boolean) =
        lokasiRepository.setLokasiSekarang(lokasi, state)

}