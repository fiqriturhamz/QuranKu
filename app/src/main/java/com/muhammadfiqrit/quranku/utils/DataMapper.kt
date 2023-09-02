package com.muhammadfiqrit.quranku.utils

import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.remote.response.SuratResponse

object DataMapper {
    fun mapResponsesToEntities(input: List<SuratResponse>): List<SuratEntity> {
        val suratList = ArrayList<SuratEntity>()
        input.map {
            val surat = SuratEntity(
                nomorSurat = it.nomor,
                jumlahAyat = it.jumlahAyat,
                arti = it.arti,
                deskripsi = it.deskripsi,
                namaSurat = it.nama,
                tempatTurun = it.tempatTurun,
                namaLatin = it.namaLatin

            )
            suratList.add(surat)
        }
        return suratList
    }
}