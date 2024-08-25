package com.muhammadfiqrit.quranku.core.mapper

import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirWithSuratEntity
import com.muhammadfiqrit.quranku.core.data.source.remote.response.tafsir.TafsirItemResponse
import com.muhammadfiqrit.quranku.core.domain.model.detail.TafsirWithSurat
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.Tafsir

object TafsirMapper {
    fun responsesToEntities(tafsir: List<TafsirItemResponse>, nomorSurat: Int) =
        tafsir.map {
            TafsirEntity(
                ayat = it.ayat,
                teks = it.teks,
                nomorSurat = nomorSurat,
            )
        }


    fun toDomain(input: List<TafsirEntity>) =
        input.map {
            Tafsir(
                ayat = it.ayat,
                teks = it.teks,
                id = it.id,
                nomorSurat = it.nomorSurat,
                isLastRead = it.isLastRead
            )
        }

    fun toDomain(input: TafsirEntity) =
        Tafsir(
            ayat = input.ayat,
            nomorSurat = input.nomorSurat,
            teks = input.teks,
            id = input.id,
            isLastRead = input.isLastRead
        )

    fun toEntity(input: Tafsir) = TafsirEntity(
        ayat = input.ayat,
        teks = input.teks,
        nomorSurat = input.nomorSurat,
        isLastRead = input.isLastRead,
        id = input.id
    )

    fun toDomain(tafsirWithSuratEntity: TafsirWithSuratEntity?): TafsirWithSurat {
        return if (tafsirWithSuratEntity == null) {
            TafsirWithSurat(
                tafsir = Tafsir(id = 1, nomorSurat = 1, teks = "", isLastRead = false, ayat = 1),
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
            TafsirWithSurat(
                tafsir = Tafsir(
                    tafsirWithSuratEntity.tafsir.id,
                    ayat = tafsirWithSuratEntity.tafsir.ayat,
                    teks = tafsirWithSuratEntity.tafsir.teks,
                    nomorSurat = tafsirWithSuratEntity.tafsir.nomorSurat,
                    isLastRead = tafsirWithSuratEntity.tafsir.isLastRead
                ),
                surat = Surat(
                    tafsirWithSuratEntity.surat.nomor,
                    nama = tafsirWithSuratEntity.surat.nama,
                    jumlahAyat = tafsirWithSuratEntity.surat.jumlahAyat,
                    arti = tafsirWithSuratEntity.surat.arti,
                    isFavorite = tafsirWithSuratEntity.surat.isFavorite,
                    deskripsi = tafsirWithSuratEntity.surat.deskripsi,
                    namaLatin = tafsirWithSuratEntity.surat.namaLatin,
                    tempatTurun = tafsirWithSuratEntity.surat.tempatTurun
                )
            )
        }
    }
}


