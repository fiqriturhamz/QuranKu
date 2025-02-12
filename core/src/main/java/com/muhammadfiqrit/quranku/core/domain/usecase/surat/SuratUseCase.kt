package com.muhammadfiqrit.quranku.core.domain.usecase.surat

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.detail.Ayat
import com.muhammadfiqrit.quranku.core.domain.model.detail.AyatWithSurat
import com.muhammadfiqrit.quranku.core.domain.model.detail.DetailSurat
import com.muhammadfiqrit.quranku.core.domain.model.detail.TafsirWithSurat
import com.muhammadfiqrit.quranku.core.domain.model.surat.Surat
import com.muhammadfiqrit.quranku.core.domain.model.tafsir.Tafsir
import kotlinx.coroutines.flow.Flow

interface SuratUseCase {
    fun getAllSurat() : Flow<Resource<List<Surat>>>
    fun getSuratByNomor(nomorSurat :Int) : Flow<Resource<DetailSurat>?>
    fun getTafsir(nomorSurat: Int) : Flow<Resource<DetailSurat>?>
    fun getFavoriteSurat() : Flow<List<Surat>>
    fun setFavoriteSurat(surat: DetailSurat, state:Boolean)
    fun setAyatTerakhirDibaca(ayat: Ayat, state: Boolean)
    fun getAyatWithSurat() : Flow<AyatWithSurat>
    fun setTafsirTerakhirDibaca(tafsir : Tafsir, state: Boolean)
    fun getTafsirWithSurat() : Flow<TafsirWithSurat>
}