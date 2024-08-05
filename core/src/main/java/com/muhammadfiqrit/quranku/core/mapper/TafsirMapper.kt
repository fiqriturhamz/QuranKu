package com.muhammadfiqrit.quranku.core.mapper

import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirEntity
import com.muhammadfiqrit.quranku.core.data.source.remote.response.tafsir.TafsirItemResponse
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
        input.map { Tafsir(ayat = it.ayat, teks = it.teks) }
}


