package com.muhammadfiqrit.quranku.domain.repository

import androidx.lifecycle.LiveData
import com.muhammadfiqrit.quranku.data.Resource
import com.muhammadfiqrit.quranku.domain.model.Surat

interface ISuratRepository {
    fun getAllSurat() : LiveData<Resource<List<Surat>>>
}