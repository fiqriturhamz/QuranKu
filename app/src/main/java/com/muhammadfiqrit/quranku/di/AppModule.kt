package com.muhammadfiqrit.quranku.di

import com.muhammadfiqrit.quranku.core.domain.usecase.sholat.SholatInteractor
import com.muhammadfiqrit.quranku.core.domain.usecase.sholat.SholatUseCase
import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratInteractor
import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratUseCase
import com.muhammadfiqrit.quranku.detail.DetailSuratViewModel
import com.muhammadfiqrit.quranku.detail.tafsir.TafsirViewModel
import com.muhammadfiqrit.quranku.favorite.FavoriteViewModel
import com.muhammadfiqrit.quranku.home.HomeViewModel
import com.muhammadfiqrit.quranku.surat.SuratViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SuratUseCase> { SuratInteractor(get()) }
    factory<SholatUseCase> { SholatInteractor(get()) }
}
val viewModelModule = module {
    viewModel { SuratViewModel(get()) }
    viewModel { DetailSuratViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { TafsirViewModel(get()) }
    viewModel { HomeViewModel(get()) }

}