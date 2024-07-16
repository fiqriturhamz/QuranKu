package com.muhammadfiqrit.quranku.core.utils

import com.muhammadfiqrit.quranku.core.data.source.local.entity.sholat.lokasi.LokasiEntity
import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi.ResponseSemuaLokasiItem
import com.muhammadfiqrit.quranku.core.domain.model.lokasi.Lokasi

object DataMapperLokasi {
    fun mapLokasiResponsesToLokasiEntities(input: List<ResponseSemuaLokasiItem>): List<LokasiEntity> {
        val lokasiList = ArrayList<LokasiEntity>()
        input.map {
            val lokasi = LokasiEntity(
                idLokasi = it.id,
                namaLokasi = it.lokasi
            )
            lokasiList
                .add(lokasi)
        }
        return lokasiList

    }

    fun mapLokasiEntitiesToListLokasi(input: List<LokasiEntity>): List<Lokasi> {
        return input.map {
            Lokasi(
                namaLokasi = it.namaLokasi,
                idLokasi = it.idLokasi,
                lokasiSekarang = it.lokasiSekarang
            )
        }
    }

    fun mapLokasiEntityToLokasi(input: LokasiEntity?): Lokasi {
        /*      val nonNullInput = input ?: return Lokasi(idLokasi = "1301", namaLokasi = "", lokasiSekarang = false)
              return Lokasi(
                  idLokasi = nonNullInput.idLokasi,
                  namaLokasi = nonNullInput.namaLokasi,
                  lokasiSekarang = nonNullInput.lokasiSekarang
              )*/
        return if (input == null) {
            Lokasi(idLokasi = "1301", namaLokasi = "Jakarta", lokasiSekarang = false)
        } else {
            Lokasi(
                idLokasi = input.idLokasi,
                namaLokasi = input.namaLokasi,
                lokasiSekarang = input.lokasiSekarang
            )
        }

    }


    fun mapDomainLokasiToLokasiEntity(input: Lokasi): LokasiEntity {

        return LokasiEntity(
            idLokasi = input.idLokasi,
            namaLokasi = input.namaLokasi,
            lokasiSekarang = input.lokasiSekarang
        )
    }
}