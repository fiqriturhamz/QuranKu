package com.muhammadfiqrit.quranku.core.domain.usecase.quote

import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.quote.Quote
import com.muhammadfiqrit.quranku.core.domain.repository.IQuoteRepository
import kotlinx.coroutines.flow.Flow

class QuoteInteractor(private val iQuoteRepository: IQuoteRepository) : QuoteUseCase{
    override fun getSemuaQuotes(): Flow<Resource<List<Quote>>> {
        return iQuoteRepository.getSemuaQuote()
    }
}