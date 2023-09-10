package com.muhammadfiqrit.quranku.domain.model.detail

data class DetailSurat(
    val nomor : Int,
    val nama :  String,
    val jumlahAyat : Int,
    val arti : String,
    val namaLatin : String,
    val deskripsi : String,
    val tempatTurun : String,
    val isFavorite : Boolean,

    )
