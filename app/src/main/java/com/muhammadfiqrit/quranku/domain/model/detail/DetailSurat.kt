package com.muhammadfiqrit.quranku.domain.model.detail

import com.muhammadfiqrit.quranku.data.source.remote.response.detail.AyatResponse

data class DetailSurat(
    var namaSurat : String,
    var jumlahAyat : Int,
    var namaLatin : String,
    var tempatTurun : String,
    var arti : String,
    var nomorSurat : Int,
    var deskripsi : String,
    var ayat : List<Ayat>
)
