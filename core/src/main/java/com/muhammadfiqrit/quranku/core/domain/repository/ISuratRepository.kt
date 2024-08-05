package com.muhammadfiqrit.quranku.core.domain.repository

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.data.source.local.entity.tafsir.TafsirEntity
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.core.domain.model.detail.AyatWithSurat
import com.muhammadfiqrit.quranku.core.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.Tafsir
import kotlinx.coroutines.flow.Flow

interface ISuratRepository {
    fun getAllSurat(): Flow<Resource<List<Surat>>>

    fun getSuratByNomor(nomorSurat: Int): Flow<Resource<DetailSurat>>

    fun getTafsir(nomorSurat: Int): Flow<Resource<DetailSurat>>

    fun getFavoriteSurat() : Flow<List<Surat>>

    fun setFavoriteSurat(surat : DetailSurat, newState:Boolean)

    fun getAyatTerakhirDibaca() : Flow<Ayat>
    fun setAyatTerakhirDibaca(ayat : Ayat, newState: Boolean)

    fun getAyatWithSurat() : Flow<AyatWithSurat>

    /*

     fun getAyatTerakhirDibaca() : Flow<Ayat>
     fun setAyatTerakhirDibaca(ayat : Ayat, newState: Boolean)

     fun getTafsir(nomorSurat : Int) : Flow<Resource<List<TafsirItem>>>
 */


}