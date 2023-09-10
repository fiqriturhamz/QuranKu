package com.muhammadfiqrit.quranku.di

import com.muhammadfiqrit.quranku.domain.usecase.SuratInteractor
import com.muhammadfiqrit.quranku.domain.usecase.SuratUseCase
import com.muhammadfiqrit.quranku.ui.detail.DetailSuratViewModel
import com.muhammadfiqrit.quranku.ui.surat.SuratViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SuratUseCase> { SuratInteractor(get()) }
}
val viewModelModule = module {
    viewModel{ SuratViewModel(get()) }
    viewModel{DetailSuratViewModel(get())}
}