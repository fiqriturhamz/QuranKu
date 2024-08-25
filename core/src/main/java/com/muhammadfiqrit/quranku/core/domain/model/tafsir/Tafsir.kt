package com.muhammadfiqrit.quranku.core.domain.model.tafsir

data class Tafsir(
    var id : Long,
    var ayat: Int,
    var teks: String,
    var nomorSurat : Int,
    var isLastRead : Boolean

)
