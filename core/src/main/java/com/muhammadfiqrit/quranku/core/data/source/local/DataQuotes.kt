package com.muhammadfiqrit.quranku.core.data.source.local

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.quote.Quote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object DataQuotes {
    fun quotes(): Flow<Resource<List<Quote>>> {
        val listQuotes = flow {
            try {
                val newQuote = listOf(
                    Quote("Ingatlah Aku, maka Aku akan mengingatmu", "Al-Baqarah:152"),
                    Quote(
                        "Allah tidak membebani seseorang melainkan sesuai dengan kesanggupannya",
                        "Al-Baqarah:286"
                    ),
                    Quote("Janganlah kamu bersedih, sesungguhnya Allah bersamamu", "At-Tawbah:40"),
                    Quote("Sesungguhnya bersama kesulitan ada kemudahan", "Al-Insyirah:6"),
                    Quote("Tuhanmu tidak melupakanmu dan tidak pula meninggalkanmu", "Ad-Dhuha:3"),
                    Quote("Orang yang sabar adalah orang yang paling bijaksana", "Ali Imran:200"),
                    Quote("Allah bersama orang-orang yang sabar", "Al-Baqarah:249"),
                    Quote("Berdoalah kepada-Ku, niscaya akan Kuperkenankan bagimu", "Ghafir:60"),
                    Quote(
                        "Dan Dia lah yang mengabulkan doa orang yang dalam kesulitan",
                        "An-Naml:62"
                    ),
                    Quote(
                        "Wahai orang-orang yang beriman, mintalah pertolongan dengan sabar dan shalat",
                        "Al-Baqarah:153"
                    ),
                    Quote(
                        "Dan barangsiapa bertakwa kepada Allah, niscaya Dia akan memberinya jalan keluar",
                        "At-Talaq:2"
                    ),
                    Quote(
                        "Sungguh, Allah tidak akan mengubah nasib suatu kaum sebelum mereka mengubah nasib mereka sendiri",
                        "Ar-Ra'd:11"
                    ),
                    Quote(
                        "Dan jangan sekali-kali kamu mengira bahwa Allah lalai dari apa yang diperbuat oleh orang-orang yang zalim",
                        "Ibrahim:42"
                    ),
                    Quote(
                        "Barangsiapa yang bertawakkal kepada Allah, maka Allah akan mencukupinya",
                        "At-Talaq:3"
                    ),
                    Quote("Tiada Tuhan selain Allah, dan Muhammad adalah utusan Allah", "Hadith"),
                    Quote(
                        "Sesungguhnya amal itu tergantung pada niatnya",
                        "Hadith - Diriwayatkan oleh Al-Bukhari dan Muslim"
                    )

                )
                emit(Resource.Success(newQuote))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Unknown Error"))
            }


        }

        return listQuotes
    }
}