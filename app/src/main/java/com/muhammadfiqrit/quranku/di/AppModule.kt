package com.muhammadfiqrit.quranku.di

import com.muhammadfiqrit.quranku.core.domain.usecase.SuratInteractor
import com.muhammadfiqrit.quranku.core.domain.usecase.SuratUseCase
import com.muhammadfiqrit.quranku.detail.DetailSuratViewModel
import com.muhammadfiqrit.quranku.favorite.FavoriteViewModel
import com.muhammadfiqrit.quranku.surat.SuratViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SuratUseCase> { SuratInteractor(get()) }
}
val viewModelModule = module {
    viewModel { SuratViewModel(get()) }
    viewModel { DetailSuratViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}