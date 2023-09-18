package com.muhammadfiqrit.quranku.core.di

import androidx.room.Room
import com.muhammadfiqrit.quranku.core.data.Repository.SholatRepository
import com.muhammadfiqrit.quranku.core.data.Repository.SuratRepository
import com.muhammadfiqrit.quranku.core.data.source.local.SuratLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.local.room.SuratDatabase
import com.muhammadfiqrit.quranku.core.data.source.remote.SholatRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.SuratRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.network.SholatService
import com.muhammadfiqrit.quranku.core.data.source.remote.network.SuratService
import com.muhammadfiqrit.quranku.core.domain.repository.ISholatRepository
import com.muhammadfiqrit.quranku.core.domain.repository.ISuratRepository
import com.muhammadfiqrit.quranku.core.utils.AppExecutors
import com.muhammadfiqrit.quranku.core.utils.Utilities.BASE_URL_SHOLAT
import com.muhammadfiqrit.quranku.core.utils.Utilities.BASE_URL_SURAT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory {
        get<SuratDatabase>().suratDao()
    }
    single {
        Room.databaseBuilder(androidContext(), SuratDatabase::class.java, "Surat.db")
            .fallbackToDestructiveMigration().build()
    }
}
val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofitSurat = Retrofit.Builder()
            .baseUrl(BASE_URL_SURAT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofitSurat.create(SuratService::class.java)
    }

    single {
        val retrofitSolat = Retrofit.Builder()
            .baseUrl(BASE_URL_SHOLAT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofitSolat.create(SholatService::class.java)
    }
}

val repositoryModule = module {
    single {
        SuratLocalDataSource(get())
    }
    single { SholatRemoteDataSource(get()) }
    single { SuratRemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ISuratRepository> {
        SuratRepository(
            get(),
            get(),
            get()
        )
    }
    single<ISholatRepository> { SholatRepository(get(), get()) }


}