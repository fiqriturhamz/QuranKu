package com.muhammadfiqrit.quranku.core.domain.model.detail

data class Ayat(
    var nomorAyat : Int,
    var teksArab : String,
    var teksLatin : String,
    var teksIndonesia : String,
    var nomorSurat : Int,
    var ayatTerakhirDibaca : Boolean,
)
