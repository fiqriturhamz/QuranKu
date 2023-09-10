package com.muhammadfiqrit.quranku.utils

import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.AyatResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.DataDetailSuratResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.surat.SuratResponse
import com.muhammadfiqrit.quranku.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.domain.model.surat.Surat
import kotlinx.coroutines.flow.flowOf


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
                isFavorite = false
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


    /*    fun mapDataDetailSuratResponseToDetailSurat(input: DataDetailSuratResponse) =
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
        nomor = input.nomor,
        nama = input.nama,
        namaLatin = input.namaLatin,
        arti = input.arti,
        jumlahAyat = input.jumlahAyat,
        tempatTurun = input.tempatTurun,
        deskripsi = input.deskripsi,
        isFavorite = input.isFavorite
    )

    fun mapSuratEntityToDetailSurat(input: SuratEntity) =
        DetailSurat(
            nomor = input.nomor,
            nama = input.nama,
            namaLatin = input.namaLatin,
            arti = input.arti,
            jumlahAyat = input.jumlahAyat,
            tempatTurun = input.tempatTurun,
            deskripsi = input.deskripsi,
            isFavorite = input.isFavorite,
        )


    fun mapAyatEntitiesToAyat(input: List<AyatEntity>) =
        input.map {
            Ayat(
                nomorAyat = it.nomorAyat,
                teksArab = it.teksArab,
                teksLatin = it.teksLatin,
                teksIndonesia = it.teksIndonesia
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
            isFavorite = false
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
                nomorSurat = nomorSurat

            )
        }


    }

}






