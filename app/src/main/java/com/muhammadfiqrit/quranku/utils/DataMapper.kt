package com.muhammadfiqrit.quranku.utils

import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.remote.response.SuratResponse
import com.muhammadfiqrit.quranku.domain.model.Surat

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

    fun mapEntityToDomain(input: List<SuratEntity>): List<Surat> =
        input.map {
            Surat(
                nomorSurat = it.nomorSurat,
                namaSurat = it.namaSurat,
                jumlahAyat = it.jumlahAyat,
                arti = it.arti,
                deskripsi = it.deskripsi,
                tempatTurun = it.tempatTurun,
                namaLatin = it.namaLatin
            )

        }

    fun mapDomainToEntity(input: Surat) = SuratEntity(
        namaLatin = input.namaLatin,
        namaSurat = input.namaSurat,
        nomorSurat = input.nomorSurat,
        jumlahAyat = input.jumlahAyat,
        deskripsi = input.deskripsi,
        arti = input.arti,
        tempatTurun = input.tempatTurun
    )

}