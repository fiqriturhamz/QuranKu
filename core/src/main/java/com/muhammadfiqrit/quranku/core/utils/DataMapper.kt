package com.muhammadfiqrit.quranku.core.utils

import androidx.annotation.Nullable
import com.muhammadfiqrit.quranku.core.data.source.local.entity.surat.SuratEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.detail.SuratSelanjutnyaEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.sholat.lokasi.LokasiEntity
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirEntity
import com.muhammadfiqrit.quranku.core.data.source.remote.response.detail.AyatResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.detail.DataDetailSuratResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.detail.SuratSelanjutnyaResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.jadwal.ResponseJadwalDataHarian
import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi.ResponseSemuaLokasiItem
import com.muhammadfiqrit.quranku.core.data.source.remote.response.surat.ResponseSurat
import com.muhammadfiqrit.quranku.core.data.source.remote.response.tafsir.TafsirItemResponse
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.core.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.core.domain.model.detail.SuratSelanjutnya
import com.muhammadfiqrit.quranku.core.domain.model.lokasi.Lokasi
import com.muhammadfiqrit.quranku.core.domain.model.sholat.jadwal.JadwalDataHarian
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.TafsirItem
import kotlinx.coroutines.flow.flowOf


object DataMapper {
    fun mapSuratResponsesToSuratEntities(input: List<ResponseSurat>): List<SuratEntity> {
        val suratList = ArrayList<SuratEntity>()
        input.map {
            val surat = SuratEntity(
                nomor = it.nomor,
                jumlahAyat = it.jumlahAyat,
                arti = it.arti,
                deskripsi = it.deskripsi,
                nama = it.nama,
                tempatTurun = it.tempatTurun,
                namaLatin = it.namaLatin,
                isFavorite = false,

                )
            suratList.add(surat)
        }
        return suratList
    }

    fun mapSuratEntitiesToSurats(input: List<SuratEntity>): List<Surat> =
        input.map {
            Surat(
                nomor = it.nomor,
                nama = it.nama,
                jumlahAyat = it.jumlahAyat,
                arti = it.arti,
                deskripsi = it.deskripsi,
                tempatTurun = it.tempatTurun,
                namaLatin = it.namaLatin,

                )

        }

    /*
            fun mapDataDetailSuratResponseToDetailSurat(input: DataDetailSuratResponse) =
                flowOf(
                    DetailSurat(
                        nama = input.nama,
                        nomor = input.nomor,
                        jumlahAyat = input.jumlahAyat,
                        tempatTurun = input.tempatTurun,
                        arti = input.arti,
                        deskripsi = input.deskripsi,
                        namaLatin = input.namaLatin,
                        ayat = input.ayat.map { ayatResponse ->
                            Ayat(
                                nomorAyat = ayatResponse.nomorAyat,
                                teksArab = ayatResponse.teksArab,
                                teksIndonesia = ayatResponse.teksIndonesia,
                                teksLatin = ayatResponse.teksLatin
                            )
                        },
                        isFavorite = false
                    )
                )*/

    fun mapDetailSuratToSuratEntity(input: DetailSurat) = SuratEntity(

        nomor = input.surat.nomor,
        nama = input.surat.nama,
        namaLatin = input.surat.namaLatin,
        arti = input.surat.arti,
        jumlahAyat = input.surat.jumlahAyat,
        tempatTurun = input.surat.tempatTurun,
        deskripsi = input.surat.deskripsi,
        isFavorite = false
    )

    fun mapSuratEntityToDetailSurat(input: SuratEntity) =
        Surat(

            nomor = input.nomor,
            nama = input.nama,
            jumlahAyat = input.jumlahAyat,
            arti = input.arti,
            namaLatin = input.namaLatin,
            deskripsi = input.deskripsi,
            tempatTurun = input.tempatTurun


        )


    fun mapAyatEntitiesToAyat(input: List<AyatEntity>) =
        input.map {
            Ayat(
                nomorAyat = it.nomorAyat,
                teksArab = it.teksArab,
                teksLatin = it.teksLatin,
                teksIndonesia = it.teksIndonesia,
                nomorSurat = it.nomorSurat
            )
        }


    fun mapDataDetailSuratResponseToSuratEntity(input: DataDetailSuratResponse): SuratEntity {
        return SuratEntity(
            nama = input.nama,
            namaLatin = input.namaLatin,
            deskripsi = input.deskripsi,
            arti = input.arti,
            jumlahAyat = input.jumlahAyat,
            nomor = input.nomor,
            tempatTurun = input.tempatTurun,
            isFavorite = false,

            )
    }

    fun mapAyatResponsesToAyatEntities(
        ayatList: List<AyatResponse>,
        nomorSurat: Int
    ): List<AyatEntity> {
        return ayatList.map { ayat ->
            AyatEntity(
                nomorAyat = ayat.nomorAyat,
                teksLatin = ayat.teksLatin,
                teksIndonesia = ayat.teksIndonesia,
                teksArab = ayat.teksArab,
                nomorSurat = nomorSurat,
            )
        }


    }

    fun suratSelanjutnyaResponseToSuratSelanjutnyaEntities(
        it: SuratSelanjutnyaResponse,
        nomorSurat: Int
    ): SuratSelanjutnyaEntity {
        // Cek tipe data "it" untuk menentukan cara mengonversinya

        // Jika "it" adalah objek SuratSelanjutnyaResponse, gunakan langsung
        return SuratSelanjutnyaEntity(
            nama = it.nama,
            namaLatin = it.namaLatin,
            nomorSurat = nomorSurat,
            jumlahAyat = it.jumlahAyat,
            nomor = it.nomor
        )

    }


    fun suratSelanjutnyaEntityToSuratSelanjutnya(
        suratSelanjutnyaEntity: SuratSelanjutnyaEntity?,
    ): SuratSelanjutnya {
        return SuratSelanjutnya(
            suratSelanjutnyaEntity?.nomor,
            suratSelanjutnyaEntity?.nama,
            suratSelanjutnyaEntity?.namaLatin,
            suratSelanjutnyaEntity?.jumlahAyat,
            suratSelanjutnyaEntity?.nomorSurat
        )
    }

    fun tafsirResponseToTafsirEntity(tafsir: List<TafsirItemResponse>, nomorSurat: Int) =
        tafsir.map { TafsirEntity(ayat = it.ayat, teks = it.teks, nomorSurat = nomorSurat) }


    fun tafsirEntitiesToTafsir(input: List<TafsirEntity>) =
        input.map { TafsirItem(ayat = it.ayat, teks = it.teks) }

    fun responseJadwalDataHarianToJadwalDataHarian(input: ResponseJadwalDataHarian) =
        flowOf(
            JadwalDataHarian(
                id = input.id,
                daerah = input.daerah,
                lokasi = input.lokasi,
                dhuha = input.jadwal.dhuha,
                dzuhur = input.jadwal.dzuhur,
                ashar = input.jadwal.ashar,
                imsak = input.jadwal.imsak,
                isya = input.jadwal.isya,
                maghrib = input.jadwal.maghrib,
                subuh = input.jadwal.subuh,
                terbit = input.jadwal.terbit,
                tanggal = input.jadwal.tanggal
            )
        )


    fun mapLokasiResponsesToLokasiEntities(input: List<ResponseSemuaLokasiItem>): List<LokasiEntity> {
        val lokasiList = ArrayList<LokasiEntity>()
        input.map {
            val lokasi = LokasiEntity(
                idLokasi = it.id,
                namaLokasi = it.lokasi
            )
            lokasiList
                .add(lokasi)
        }
        return lokasiList

    }

    fun mapLokasiEntitiesToListLokasi(input: List<LokasiEntity>): List<Lokasi> {
        return input.map {
            Lokasi(
                namaLokasi = it.namaLokasi,
                idLokasi = it.idLokasi,
                lokasiSekarang = it.lokasiSekarang
            )
        }
    }

    fun mapLokasiEntityToLokasi( input: LokasiEntity?): Lokasi {
        /*      val nonNullInput = input ?: return Lokasi(idLokasi = "1301", namaLokasi = "", lokasiSekarang = false)
              return Lokasi(
                  idLokasi = nonNullInput.idLokasi,
                  namaLokasi = nonNullInput.namaLokasi,
                  lokasiSekarang = nonNullInput.lokasiSekarang
              )*/
        return if (input == null) {
            Lokasi(idLokasi = "1301", namaLokasi = "Jakarta", lokasiSekarang = false)
        } else {
            Lokasi(
                idLokasi = input.idLokasi,
                namaLokasi = input.namaLokasi,
                lokasiSekarang = input.lokasiSekarang
            )
        }
    }


    fun mapDomainLokasiToLokasiEntity(input: Lokasi) = LokasiEntity(
        idLokasi = input.idLokasi,
        namaLokasi = input.namaLokasi,
        lokasiSekarang = input.lokasiSekarang
    )


}










