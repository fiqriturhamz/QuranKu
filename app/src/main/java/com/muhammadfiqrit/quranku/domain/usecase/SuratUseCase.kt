package com.muhammadfiqrit.quranku.domain.usecase

import com.muhammadfiqrit.quranku.data.Resource
import com.muhammadfiqrit.quranku.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.domain.model.surat.Surat
import kotlinx.coroutines.flow.Flow

interface SuratUseCase {
    fun getAllSurat() : Flow<Resource<List<Surat>>>
    fun getSuratByNomor(nomorSurat :Int) : Flow<Resource<DetailSurat>>


/*    fun getAyatBySurat(nomorSurat: Int) : Flow<Resource<List<Ayat>>>*/


    fun getFavoriteSurat() : Flow<List<Surat>>

    fun setFavoriteSurat(surat:DetailSurat, state:Boolean)
}