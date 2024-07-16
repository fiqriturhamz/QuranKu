package com.muhammadfiqrit.quranku.core.utils

import com.muhammadfiqrit.quranku.core.data.source.local.entity.surat.SuratEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.SuratSelanjutnyaEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirEntity
import com.muhammadfiqrit.quranku.core.data.source.remote.response.detail.AyatResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.detail.DataDetailSuratResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.detail.SuratSelanjutnyaResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.surat.ResponseSurat
import com.muhammadfiqrit.quranku.core.data.source.remote.response.tafsir.TafsirItemResponse
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.core.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.core.domain.model.detail.SuratSelanjutnya
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.TafsirItem


object DataMapperSurat {
    fun mapSuratResponsesToSuratEntities(input: List<ResponseSurat>): List<SuratEntity> {
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
                isFavorite = it.isFavorite
            )

        }


    fun mapDetailSuratToSuratEntity(input: DetailSurat) = SuratEntity(

        nomor = input.surat.nomor,
        nama = input.surat.nama,
        namaLatin = input.surat.namaLatin,
        arti = input.surat.arti,
        jumlahAyat = input.surat.jumlahAyat,
        tempatTurun = input.surat.tempatTurun,
        deskripsi = input.surat.deskripsi,
        isFavorite = input.surat.isFavorite
    )

    fun mapSuratEntityToDetailSurat(input: SuratEntity) =
        Surat(
            nomor = input.nomor,
            nama = input.nama,
            jumlahAyat = input.jumlahAyat,
            arti = input.arti,
            namaLatin = input.namaLatin,
            deskripsi = input.deskripsi,
            tempatTurun = input.tempatTurun,
            isFavorite = input.isFavorite


        )


    fun mapAyatEntitiesToAyat(input: List<AyatEntity>) =
        input.map {
            Ayat(
                nomorAyat = it.nomorAyat,
                teksArab = it.teksArab,
                teksLatin = it.teksLatin,
                teksIndonesia = it.teksIndonesia,
                nomorSurat = it.nomorSurat,
                ayatTerakhirDibaca = it.isLastRead
            )
        }

    fun mapAyatEntityToAyat(input: AyatEntity): Ayat {
        return Ayat(
            nomorAyat = input.nomorAyat,
            teksArab = input.teksArab,
            teksIndonesia = input.teksIndonesia,
            teksLatin = input.teksLatin,
            nomorSurat = input.nomorSurat,
            ayatTerakhirDibaca = input.isLastRead
        )
    }

    fun mapAyatToAyatEntity(input: Ayat): AyatEntity {
        return AyatEntity(
            nomorSurat = input.nomorSurat,
            nomorAyat = input.nomorAyat,
            teksLatin = input.teksLatin,
            teksIndonesia = input.teksIndonesia,
            teksArab = input.teksArab,
            isLastRead = input.ayatTerakhirDibaca
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
                nomorSurat = nomorSurat,
                isLastRead = false

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

    fun tafsirResponseToTafsirEntity(tafsir: List<TafsirItemResponse>, nomorSurat: Int) =
        tafsir.map { TafsirEntity(ayat = it.ayat, teks = it.teks, nomorSurat = nomorSurat) }


    fun tafsirEntitiesToTafsir(input: List<TafsirEntity>) =
        input.map { TafsirItem(ayat = it.ayat, teks = it.teks) }


}










