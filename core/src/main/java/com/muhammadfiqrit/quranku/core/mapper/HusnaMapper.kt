package com.muhammadfiqrit.quranku.core.mapper

import com.muhammadfiqrit.quranku.core.data.source.local.entity.HusnaEntity
import com.muhammadfiqrit.quranku.core.data.source.remote.response.husna.ResponseHusna
import com.muhammadfiqrit.quranku.core.domain.model.husna.Husna

object HusnaMapper {
    fun responsesToEntities(input: List<ResponseHusna>): List<HusnaEntity> {
        val listHusna = ArrayList<HusnaEntity>()
        input.map {
            val husnaEntity = HusnaEntity(
                id = it.id,
                teksArab = it.teksArab,
                teksLatin = it.teksLatin,
                teksIndo = it.teksIndo
            )
            listHusna.add(husnaEntity)
        }
        return listHusna
    }

    fun entitiesToDomain(input: List<HusnaEntity>): List<Husna> {
        val listHusna = ArrayList<Husna>()
        input.map {
            val husna = Husna(
                id = it.id,
                teksIndo = it.teksIndo,
                teksLatin = it.teksLatin,
                teksArab = it.teksArab
            )
            listHusna.add(husna)
        }
        return listHusna
    }
}