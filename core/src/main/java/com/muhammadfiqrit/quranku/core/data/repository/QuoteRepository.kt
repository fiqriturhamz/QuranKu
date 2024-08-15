package com.muhammadfiqrit.quranku.core.data.repository

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.quote.Quote
import com.muhammadfiqrit.quranku.core.domain.repository.IQuoteRepository
import com.muhammadfiqrit.quranku.core.data.source.local.DataQuotes
import kotlinx.coroutines.flow.Flow

class QuoteRepository : IQuoteRepository {
    override fun getSemuaQuote(): Flow<Resource<List<Quote>>> {
        return DataQuotes.quotes()
    }

}