package com.muhammadfiqrit.quranku.core.mapper

import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.core.data.source.remote.response.detail.AyatResponse
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat

object AyatMapper {
    fun responsesToEntities(
        input: List<AyatResponse>,
        nomorSurat: Int
    ): List<AyatEntity> {
        val ayatList = ArrayList<AyatEntity>()

        input.map {
            val ayat = AyatEntity(
                nomorAyat = it.nomorAyat,
                nomorSurat = nomorSurat,
                teksArab = it.teksArab,
                teksLatin = it.teksLatin,
                teksIndonesia = it.teksIndonesia, isLastRead = false,


                )
            ayatList.add(ayat)
        }
        return ayatList

    }

    fun entitiesToDomain(input: List<AyatEntity>, nomorSurat: Int): List<Ayat> {
        val listAyat = ArrayList<Ayat>()
        input.map {
            val ayat = Ayat(
                id = it.id,
                nomorSurat = nomorSurat,
                nomorAyat = it.nomorAyat,
                teksArab = it.teksArab,
                teksIndonesia = it.teksIndonesia,
                teksLatin = it.teksLatin,
                isLastRead = it.isLastRead
            )
            listAyat.add(ayat)
        }
        return listAyat
    }

    fun entityToDomain(input: AyatEntity?): Ayat {
        return if (input == null) {
            Ayat(
                id = 1,
                nomorAyat = 1,
                nomorSurat = 3,
                teksLatin = "latin",
                teksArab = "arab",
                teksIndonesia = "indonesia",
                isLastRead = true
            )
        } else {
            Ayat(
                id = input.id,
                nomorSurat = input.nomorSurat,
                nomorAyat = input.nomorAyat,
                teksLatin = input.teksLatin,
                teksArab = input.teksArab,
                teksIndonesia = input.teksIndonesia,
                isLastRead = input.isLastRead
            )
        }

    }

    fun domainToEntity(input: Ayat): AyatEntity {
        return AyatEntity(
            id = input.id,
            nomorAyat = input.nomorAyat,
            nomorSurat = input.nomorSurat,
            teksIndonesia = input.teksIndonesia,
            teksArab = input.teksArab,
            teksLatin = input.teksLatin, isLastRead = input.isLastRead,


            )
    }
}