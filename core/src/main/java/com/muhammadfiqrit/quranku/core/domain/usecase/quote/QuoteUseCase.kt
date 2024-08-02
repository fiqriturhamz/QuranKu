package com.muhammadfiqrit.quranku.core.domain.usecase.quote

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.quote.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteUseCase {
    fun getSemuaQuotes() : Flow<Resource<List<Quote>>>
}