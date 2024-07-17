package com.muhammadfiqrit.quranku.core.domain.model.detail

import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat

data class DetailSurat(
    val surat : Surat,
    val ayat : List<Ayat>?,
//    val suratSelanjutnya: SuratSelanjutnya,
)
