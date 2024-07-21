package com.muhammadfiqrit.quranku.core.utils

import com.muhammadfiqrit.quranku.core.data.source.local.entity.doa.DoaEntity
import com.muhammadfiqrit.quranku.core.data.source.remote.response.doa.ResponseDoa
import com.muhammadfiqrit.quranku.core.domain.model.doa.Doa

object DataMapperDoa {
    fun mapDataDoaResponsesToDoaEntities(input: List<ResponseDoa>): List<DoaEntity> {
        val listDoa = ArrayList<DoaEntity>()
        input.map {
            val doa = DoaEntity(
                teksArab = it.teksArab,
                teksIndo = it.teksIndo,
                source = it.source,
                judul = it.judul,
                id = null
            )
            listDoa.add(doa)
        }
        return listDoa
    }

    fun mapDoaEntitiesToDoas(input: List<DoaEntity>): List<Doa> {
        val listDoa = ArrayList<Doa>()
        input.map {
            val doa = Doa(
                teksIndo = it.teksIndo,
                teksArab = it.teksArab,
                source = it.source,
                judul = it.judul,
                id = it.id
            )
            listDoa.add(doa)
        }
        return listDoa
    }
}