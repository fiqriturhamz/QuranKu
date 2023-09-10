package com.muhammadfiqrit.quranku.utils

import android.provider.ContactsContract.RawContacts.Data
import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.local.entity.detail.AyatEntity
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.DataDetailSuratResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.surat.SuratResponse
import com.muhammadfiqrit.quranku.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.domain.model.surat.Surat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn


object DataMapper {
    fun mapResponsesToEntities(input: List<SuratResponse>): List<SuratEntity> {
        val suratList = ArrayList<SuratEntity>()
        input.map {
            val surat = SuratEntity(
                nomor = it.nomor,
                jumlahAyat = it.jumlahAyat,
                arti = it.arti,
                deskripsi = it.deskripsi,
                nama = it.nama,
                tempatTurun = it.tempatTurun,
                namaLatin = it.namaLatin


            )
            suratList.add(surat)
        }
        return suratList
    }

    fun mapEntitiesToDomain(input: List<SuratEntity>): List<Surat> =
        input.map {
            Surat(
                nomor = it.nomor,
                nama = it.nama,
                jumlahAyat = it.jumlahAyat,
                arti = it.arti,
                deskripsi = it.deskripsi,
                tempatTurun = it.tempatTurun,
                namaLatin = it.namaLatin
            )

        }


    fun mapResponseToDomain(input: DataDetailSuratResponse) =
        flowOf(
            DetailSurat(
                namaSurat = input.nama,
                nomorSurat = input.nomor,
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
                }

            )
        )
   /* fun mapEntityToDomain(input: SuratEntity) =
        DetailSurat(
            namaSurat = input.nama,
            nomorSurat = input.nomor,
            namaLatin = input.namaLatin,
            jumlahAyat = input.jumlahAyat,
            arti = input.arti,
            tempatTurun = input.tempatTurun,
            deskripsi = input.deskripsi,
        )

    fun mapResponseToEntity(input: DataDetailSuratResponse) =
        SuratEntity(
            nama = input.nama,
            nomor = input.nomor,
            deskripsi = input.deskripsi,
            jumlahAyat = input.jumlahAyat,
            arti = input.arti,
            tempatTurun = input.tempatTurun,
            namaLatin = input.namaLatin
        )
*/
}



