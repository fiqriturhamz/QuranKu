package com.muhammadfiqrit.quranku.di


import com.muhammadfiqrit.quranku.core.domain.usecase.doa.DoaInteractor
import com.muhammadfiqrit.quranku.core.domain.usecase.doa.DoaUseCase
import com.muhammadfiqrit.quranku.detail.AyatAdapter
import com.muhammadfiqrit.quranku.detail.AyatViewModel
import com.muhammadfiqrit.quranku.husna.HusnaAdapter
import com.muhammadfiqrit.quranku.surat.SuratAdapter
import com.muhammadfiqrit.quranku.core.domain.usecase.husna.HusnaInteractor
import com.muhammadfiqrit.quranku.core.domain.usecase.husna.HusnaUseCase
import com.muhammadfiqrit.quranku.core.domain.usecase.lokasi.LokasiInteractor
import com.muhammadfiqrit.quranku.core.domain.usecase.lokasi.LokasiUseCase
import com.muhammadfiqrit.quranku.core.domain.usecase.sholat.SholatInteractor
import com.muhammadfiqrit.quranku.core.domain.usecase.sholat.SholatUseCase
import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratInteractor
import com.muhammadfiqrit.quranku.core.domain.usecase.surat.SuratUseCase
import com.muhammadfiqrit.quranku.detail.DetailSuratViewModel
import com.muhammadfiqrit.quranku.detail.tafsir.TafsirViewModel
import com.muhammadfiqrit.quranku.doa.DoaAdapter
import com.muhammadfiqrit.quranku.doa.DoaViewModel
import com.muhammadfiqrit.quranku.favorite.FavoriteViewModel
import com.muhammadfiqrit.quranku.home.HomeViewModel
import com.muhammadfiqrit.quranku.husna.HusnaViewModel

import com.muhammadfiqrit.quranku.lokasi.LokasiAdapter
import com.muhammadfiqrit.quranku.lokasi.LokasiViewModel
import com.muhammadfiqrit.quranku.surat.SuratViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SuratUseCase> { SuratInteractor(get()) }
    factory<SholatUseCase> { SholatInteractor(get()) }
    factory<LokasiUseCase> { LokasiInteractor(get()) }
    factory<HusnaUseCase> { HusnaInteractor(get()) }
    factory<DoaUseCase> { DoaInteractor(get()) }
}
val viewModelModule = module {
    viewModel { SuratViewModel(get()) }
    viewModel { DetailSuratViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { TafsirViewModel(get()) }
    viewModel { AyatViewModel(get()) }
    viewModel { LokasiViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { HusnaViewModel(get()) }
    viewModel { DoaViewModel(get()) }


}
val adapterModule = module {
    factory { SuratAdapter() }
    factory { HusnaAdapter() }
    factory { DoaAdapter() }
    factory { LokasiAdapter(get(), get()) }
    factory { AyatAdapter(get()) }
}
