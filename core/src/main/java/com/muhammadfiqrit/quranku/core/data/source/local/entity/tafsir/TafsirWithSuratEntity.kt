package com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir

import androidx.room.Embedded
import androidx.room.Relation
import com.muhammadfiqrit.quranku.core.data.source.local.entity.surat.SuratEntity

data class TafsirWithSuratEntity(
    @Embedded val tafsir: TafsirEntity,
    @Relation(
        parentColumn = "nomorSurat",
        entityColumn = "nomor"
    ) val surat: SuratEntity
)
