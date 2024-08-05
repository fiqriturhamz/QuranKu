package com.muhammadfiqrit.quranku.core.mapper

import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.jadwal.ResponseJadwalDataHarian
import com.muhammadfiqrit.quranku.core.domain.model.sholat.jadwal.JadwalDataHarian
import kotlinx.coroutines.flow.flowOf

object SholatMapper {
    fun responseToDomain(input: ResponseJadwalDataHarian) =
        flowOf(
            JadwalDataHarian(
                id = input.id,
                daerah = input.daerah,
                lokasi = input.lokasi,
                dhuha = input.jadwal.dhuha,
                dzuhur = input.jadwal.dzuhur,
                ashar = input.jadwal.ashar,
                imsak = input.jadwal.imsak,
                isya = input.jadwal.isya,
                maghrib = input.jadwal.maghrib,
                subuh = input.jadwal.subuh,
                terbit = input.jadwal.terbit,
                tanggal = input.jadwal.tanggal
            )
        )
}
