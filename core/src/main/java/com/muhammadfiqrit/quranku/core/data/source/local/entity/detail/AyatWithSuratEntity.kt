package com.muhammadfiqrit.quranku.core.data.source.local.entity.detail

import androidx.room.Embedded
import androidx.room.Relation
import com.muhammadfiqrit.quranku.core.data.source.local.entity.surat.SuratEntity

data class AyatWithSuratEntity(
    @Embedded val ayat: AyatEntity,
    @Relation(
        parentColumn = "nomorSurat",
        entityColumn = "nomor"
    ) val surat: SuratEntity
)
