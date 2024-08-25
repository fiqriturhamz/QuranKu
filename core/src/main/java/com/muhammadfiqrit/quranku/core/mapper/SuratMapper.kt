package com.muhammadfiqrit.quranku.core.mapper

import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.AyatWithSuratEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.surat.SuratEntity
import com.muhammadfiqrit.quranku.core.data.source.remote.response.surat.ResponseSurat
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.core.domain.model.detail.AyatWithSurat
import com.muhammadfiqrit.quranku.core.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
object SuratMapper {
    fun responsesToEntities(input: List<ResponseSurat>): List<SuratEntity> {
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

    fun entitiesToDomain(input: List<SuratEntity>): List<Surat> {
        return input.map {
            Surat(
                nomor = it.nomor,
                nama = it.nama,
                jumlahAyat = it.jumlahAyat,
                arti = it.arti,
                deskripsi = it.deskripsi,
                tempatTurun = it.tempatTurun,
                namaLatin = it.namaLatin,
                isFavorite = it.isFavorite,
            )
        }
    }

    fun entityToDomain(input: SuratEntity): Surat {
        return Surat(
            nomor = input.nomor,
            nama = input.nama,
            namaLatin = input.namaLatin,
            jumlahAyat = input.jumlahAyat,
            arti = input.arti,
            deskripsi = input.deskripsi,
            tempatTurun = input.tempatTurun,
            isFavorite = input.isFavorite,
        )
    }
    fun domainToEntity(input: DetailSurat) = SuratEntity(
        nomor = input.surat.nomor,
        nama = input.surat.nama,
        namaLatin = input.surat.namaLatin,
        arti = input.surat.arti,
        jumlahAyat = input.surat.jumlahAyat,
        tempatTurun = input.surat.tempatTurun,
        deskripsi = input.surat.deskripsi,
        isFavorite = input.surat.isFavorite
    )

    fun entityToDomain(ayatWithSuratEntity: AyatWithSuratEntity?): AyatWithSurat {
        return if (ayatWithSuratEntity == null) {
            AyatWithSurat(
                ayat = Ayat(
                    id = 1,
                    nomorAyat = 1,
                    teksArab = "",
                    teksLatin = "",
                    teksIndonesia = "",
                    nomorSurat = 1,
                    isLastRead = false
                ),
                surat = Surat(
                    nomor = 1,
                    nama = "Al-Fatihah",
                    jumlahAyat = 7,
                    arti = "Pembuka",
                    namaLatin = "الفاتحة",
                    deskripsi = "",
                    tempatTurun = "",
                    isFavorite = false
                )
            )
        } else {
            AyatWithSurat(
                ayat = Ayat(
                    id = ayatWithSuratEntity.ayat.id,
                    nomorSurat = ayatWithSuratEntity.ayat.nomorSurat,
                    nomorAyat = ayatWithSuratEntity.ayat.nomorAyat,
                    teksIndonesia = ayatWithSuratEntity.ayat.teksIndonesia,
                    teksArab = ayatWithSuratEntity.ayat.teksArab,
                    teksLatin = ayatWithSuratEntity.ayat.teksLatin,
                    isLastRead = ayatWithSuratEntity.ayat.isLastRead
                ),
                surat = Surat(
                    nomor = ayatWithSuratEntity.surat.nomor,
                    namaLatin = ayatWithSuratEntity.surat.namaLatin,
                    nama = ayatWithSuratEntity.surat.nama,
                    jumlahAyat = ayatWithSuratEntity.surat.jumlahAyat,
                    arti = ayatWithSuratEntity.surat.arti,
                    isFavorite = ayatWithSuratEntity.surat.isFavorite,
                    tempatTurun = ayatWithSuratEntity.surat.tempatTurun,
                    deskripsi = ayatWithSuratEntity.surat.deskripsi
                )
            )
        }
    }
}













