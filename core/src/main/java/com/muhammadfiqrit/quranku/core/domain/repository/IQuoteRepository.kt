package com.muhammadfiqrit.quranku.core.domain.repository

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.quote.Quote
import kotlinx.coroutines.flow.Flow

interface IQuoteRepository {
    fun getSemuaQuote() : Flow<Resource<List<Quote>>>
}