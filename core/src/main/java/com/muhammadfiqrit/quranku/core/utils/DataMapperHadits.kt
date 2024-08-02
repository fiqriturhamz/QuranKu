package com.muhammadfiqrit.quranku.core.utils

import com.muhammadfiqrit.quranku.core.data.source.local.entity.hadits.HaditsEntity
import com.muhammadfiqrit.quranku.core.data.source.remote.response.hadits.ResponseHaditsArbain
import com.muhammadfiqrit.quranku.core.domain.model.hadits.Hadits

object DataMapperHadits {
    fun mapHaditsResponsesToHaditsEntities(input: List<ResponseHaditsArbain>): List<HaditsEntity> {
        val listHadits = ArrayList<HaditsEntity>()
        input.map {
            val hadits = HaditsEntity(
                nomorHadits = it.noHadits,
                judulHadits = it.judulHadits,
                teksArab = it.teksArab,
                teksIndo = it.teksIndo
            )
            listHadits.add(hadits)
        }
        return listHadits
    }

    fun mapHaditsEntitiesToHadits(input: List<HaditsEntity>): List<Hadits> {
        val listHadits = ArrayList<Hadits>()
        input.map {
            val hadits = Hadits(
                nomorHadits = it.nomorHadits,
                judulHadits = it.judulHadits,
                teksIndo = it.teksIndo,
                teksArab = it.teksArab
            )
            listHadits.add(hadits)
        }
        return listHadits
    }
}