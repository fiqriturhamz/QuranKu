package com.muhammadfiqrit.quranku.core.domain.model.detail

import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.Tafsir

data class TafsirWithSurat (val tafsir : Tafsir, val surat : Surat)