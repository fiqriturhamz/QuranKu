package com.muhammadfiqrit.quranku.domain.repository

import androidx.lifecycle.LiveData
import com.muhammadfiqrit.quranku.data.Resource
import com.muhammadfiqrit.quranku.domain.model.Surat
import kotlinx.coroutines.flow.Flow

interface ISuratRepository {
    fun getAllSurat() : Flow<Resource<List<Surat>>>
}