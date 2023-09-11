package com.muhammadfiqrit.quranku.domain.model.detail

import com.muhammadfiqrit.quranku.domain.model.surat.Surat

data class DetailSurat(
  val surat : Surat,
  val ayat : List<Ayat>
)
