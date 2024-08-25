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
                    Quote("Allah tidak membebani seseorang melainkan sesuai dengan kesanggupannya", "Al-Baqarah:286"),
                    Quote("Janganlah kamu bersedih, sesungguhnya Allah bersamamu", "At-Tawbah:40"),
                    Quote("Sesungguhnya bersama kesulitan ada kemudahan", "Al-Insyirah:6"),
                    Quote("Tuhanmu tidak melupakanmu dan tidak pula meninggalkanmu", "Ad-Dhuha:3"),
                    Quote("Orang yang sabar adalah orang yang paling bijaksana", "Ali Imran:200"),
                    Quote("Allah bersama orang-orang yang sabar", "Al-Baqarah:249"),
                    Quote("Berdoalah kepada-Ku, niscaya akan Kuperkenankan bagimu", "Ghafir:60"),
                    Quote("Dan Dia lah yang mengabulkan doa orang yang dalam kesulitan", "An-Naml:62"),
                    Quote("Wahai orang-orang yang beriman, mintalah pertolongan dengan sabar dan shalat", "Al-Baqarah:153"),
                    Quote("Dan barangsiapa bertakwa kepada Allah, niscaya Dia akan memberinya jalan keluar", "At-Talaq:2"),
                    Quote("Sungguh, Allah tidak akan mengubah nasib suatu kaum sebelum mereka mengubah nasib mereka sendiri", "Ar-Ra'd:11"),
                    Quote("Dan jangan sekali-kali kamu mengira bahwa Allah lalai dari apa yang diperbuat oleh orang-orang yang zalim", "Ibrahim:42"),
                    Quote("Barangsiapa yang bertawakkal kepada Allah, maka Allah akan mencukupinya", "At-Talaq:3"),
                    Quote("Tiada Tuhan selain Allah, dan Muhammad adalah utusan Allah", "Hadith"),
                    Quote("Sesungguhnya amal itu tergantung pada niatnya", "Hadith - Diriwayatkan oleh Al-Bukhari dan Muslim"),
                    Quote("Dan hendaklah kamu bertawakkal kepada Allah Yang Maha Kuasa lagi Maha Bijaksana", "Al-Anfal:62"),
                    Quote("Jika Allah menolong kamu, maka tiada yang dapat mengalahkanmu", "Ali Imran:160"),
                    Quote("Barangsiapa yang beriman kepada Allah dan hari akhir, maka hendaklah ia berkata baik atau diam", "Hadith - Diriwayatkan oleh Al-Bukhari dan Muslim"),
                    Quote("Setiap amal baik yang kamu lakukan adalah sedekah", "Hadith - Diriwayatkan oleh Al-Bukhari"),
                    Quote("Janganlah kamu bersedih atas apa yang hilang dari dunia, karena dunia tidak ada harganya di sisi Allah", "Hadith - Diriwayatkan oleh Al-Bukhari"),
                    Quote("Sesungguhnya Allah menyukai orang yang berbuat baik", "Hadith - Diriwayatkan oleh Muslim"),
                    Quote("Sabar itu adalah cahaya", "Hadith - Diriwayatkan oleh Muslim"),
                    Quote("Apa yang ada di sisi Allah lebih baik dan lebih kekal", "Al-Qasas:60"),
                    Quote("Dan Allah berkuasa atas segala sesuatu", "Al-Mujadila:7"),
                    Quote("Orang yang tidak bersyukur kepada manusia, tidak bersyukur kepada Allah", "Hadith - Diriwayatkan oleh Abu Dawood"),
                    Quote("Perbuatan baik akan menghapuskan perbuatan buruk", "Al-Ankabut:69"),
                    Quote("Dan tidaklah kami mengutus kamu, wahai Muhammad, kecuali sebagai rahmat bagi seluruh alam", "Al-Anbiya:107"),
                    Quote("Apa yang kamu lakukan dalam hidup ini adalah untuk diri kamu sendiri", "Hadith - Diriwayatkan oleh Al-Bukhari")
                )
                emit(Resource.Success(newQuote))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Unknown Error"))
            }
        }

        return listQuotes
    }

}