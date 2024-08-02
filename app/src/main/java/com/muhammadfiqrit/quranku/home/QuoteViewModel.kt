package com.muhammadfiqrit.quranku.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.domain.model.quote.Quote
import com.muhammadfiqrit.quranku.core.domain.usecase.quote.QuoteUseCase
import kotlinx.coroutines.flow.Flow

class QuoteViewModel(private val quoteUseCase: QuoteUseCase) : ViewModel() {
    val getSemuaQuotes = quoteUseCase.getSemuaQuotes().asLiveData()
}