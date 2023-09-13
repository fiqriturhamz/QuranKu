package com.muhammadfiqrit.quranku.utils

import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.data.source.local.entity.detail.SuratSelanjutnyaEntity
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.AyatResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.DataDetailSuratResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.SuratSelanjutnyaResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.surat.SuratResponse
import com.muhammadfiqrit.quranku.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.domain.model.detail.SuratSelanjutnya
import com.muhammadfiqrit.quranku.domain.model.surat.Surat


object DataMapper {
    fun mapSuratResponsesToSuratEntities(input: List<SuratResponse>): List<SuratEntity> {
        val suratList = ArrayList<SuratEntity>()
        input.map {
            val surat = SuratEntity(
                nomor = it.nomor,
                jumlahAyat = it.jumlahAyat,
                arti = it.arti,
                deskripsi = it.deskripsi,
                nama = it.nama,
                tempatTurun = it.tempatTurun,
                namaLatin = it.namaLatin,
                isFavorite = false,

                )
            suratList.add(surat)
        }
        return suratList
    }

    fun mapSuratEntitiesToSurats(input: List<SuratEntity>): List<Surat> =
        input.map {
            Surat(
                nomor = it.nomor,
                nama = it.nama,
                jumlahAyat = it.jumlahAyat,
                arti = it.arti,
                deskripsi = it.deskripsi,
                tempatTurun = it.tempatTurun,
                namaLatin = it.namaLatin,

                )

        }

    /*
            fun mapDataDetailSuratResponseToDetailSurat(input: DataDetailSuratResponse) =
                flowOf(
                    DetailSurat(
                        nama = input.nama,
                        nomor = input.nomor,
                        jumlahAyat = input.jumlahAyat,
                        tempatTurun = input.tempatTurun,
                        arti = input.arti,
                        deskripsi = input.deskripsi,
                        namaLatin = input.namaLatin,
                        ayat = input.ayat.map { ayatResponse ->
                            Ayat(
                                nomorAyat = ayatResponse.nomorAyat,
                                teksArab = ayatResponse.teksArab,
                                teksIndonesia = ayatResponse.teksIndonesia,
                                teksLatin = ayatResponse.teksLatin
                            )
                        },
                        isFavorite = false
                    )
                )*/

    fun mapDetailSuratToSuratEntity(input: DetailSurat) = SuratEntity(

        nomor = input.surat.nomor,
        nama = input.surat.nama,
        namaLatin = input.surat.namaLatin,
        arti = input.surat.arti,
        jumlahAyat = input.surat.jumlahAyat,
        tempatTurun = input.surat.tempatTurun,
        deskripsi = input.surat.deskripsi,
        isFavorite = false
    )

    fun mapSuratEntityToDetailSurat(input: SuratEntity) =
        Surat(

            nomor = input.nomor,
            nama = input.nama,
            jumlahAyat = input.jumlahAyat,
            arti = input.arti,
            namaLatin = input.namaLatin,
            deskripsi = input.deskripsi,
            tempatTurun = input.tempatTurun


        )


    fun mapAyatEntitiesToAyat(input: List<AyatEntity>) =
        input.map {
            Ayat(
                nomorAyat = it.nomorAyat,
                teksArab = it.teksArab,
                teksLatin = it.teksLatin,
                teksIndonesia = it.teksIndonesia,
                nomorSurat = it.nomorSurat
            )
        }


    fun mapDataDetailSuratResponseToSuratEntity(input: DataDetailSuratResponse): SuratEntity {
        return SuratEntity(
            nama = input.nama,
            namaLatin = input.namaLatin,
            deskripsi = input.deskripsi,
            arti = input.arti,
            jumlahAyat = input.jumlahAyat,
            nomor = input.nomor,
            tempatTurun = input.tempatTurun,
            isFavorite = false,

            )
    }

    fun mapAyatResponsesToAyatEntities(
        ayatList: List<AyatResponse>,
        nomorSurat: Int
    ): List<AyatEntity> {
        return ayatList.map { ayat ->
            AyatEntity(
                nomorAyat = ayat.nomorAyat,
                teksLatin = ayat.teksLatin,
                teksIndonesia = ayat.teksIndonesia,
                teksArab = ayat.teksArab,
                nomorSurat = nomorSurat,
            )
        }


    }

    fun suratSelanjutnyaResponseToSuratSelanjutnyaEntities(
        it: SuratSelanjutnyaResponse,
        nomorSurat: Int
    ): SuratSelanjutnyaEntity {
        // Cek tipe data "it" untuk menentukan cara mengonversinya

        // Jika "it" adalah objek SuratSelanjutnyaResponse, gunakan langsung
        return SuratSelanjutnyaEntity(
            nama = it.nama,
            namaLatin = it.namaLatin,
            nomorSurat = nomorSurat,
            jumlahAyat = it.jumlahAyat,
            nomor = it.nomor
        )

    }


    fun suratSelanjutnyaEntityToSuratSelanjutnya(
        suratSelanjutnyaEntity: SuratSelanjutnyaEntity?,
    ): SuratSelanjutnya {
        return SuratSelanjutnya(
            suratSelanjutnyaEntity?.nomor,
            suratSelanjutnyaEntity?.nama,
            suratSelanjutnyaEntity?.namaLatin,
            suratSelanjutnyaEntity?.jumlahAyat,
            suratSelanjutnyaEntity?.nomorSurat
        )
    }

}










