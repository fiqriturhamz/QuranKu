package com.muhammadfiqrit.quranku.core.di

import androidx.room.Room
import com.muhammadfiqrit.quranku.core.data.source.remote.network.HaditsService
import com.muhammadfiqrit.quranku.core.data.repository.DoaRepository
import com.muhammadfiqrit.quranku.core.data.repository.HaditsRepository
import com.muhammadfiqrit.quranku.core.data.repository.HusnaRepository
import com.muhammadfiqrit.quranku.core.data.repository.LokasiRepository
import com.muhammadfiqrit.quranku.core.data.repository.QuoteRepository
import com.muhammadfiqrit.quranku.core.data.repository.SholatRepository
import com.muhammadfiqrit.quranku.core.data.repository.SuratRepository
import com.muhammadfiqrit.quranku.core.data.source.local.DoaLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.local.HaditsLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.local.HusnaLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.local.LokasiLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.local.SuratLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.local.room.doa.DoaDatabase
import com.muhammadfiqrit.quranku.core.data.source.local.room.hadits.HaditsDatabase
import com.muhammadfiqrit.quranku.core.data.source.local.room.husna.HusnaDatabase
import com.muhammadfiqrit.quranku.core.data.source.local.room.sholat.lokasi.LokasiDatabase
import com.muhammadfiqrit.quranku.core.data.source.local.room.surat.SuratDatabase
import com.muhammadfiqrit.quranku.core.data.source.remote.DoaRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.HaditsRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.HusnaRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.LokasiRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.SholatRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.SuratRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.network.AsmaulHusnaService
import com.muhammadfiqrit.quranku.core.data.source.remote.network.DoaService
import com.muhammadfiqrit.quranku.core.data.source.remote.network.LokasiService
import com.muhammadfiqrit.quranku.core.data.source.remote.network.SholatService
import com.muhammadfiqrit.quranku.core.data.source.remote.network.SuratService
import com.muhammadfiqrit.quranku.core.domain.repository.IDoaRepository
import com.muhammadfiqrit.quranku.core.domain.repository.IHaditsRepository
import com.muhammadfiqrit.quranku.core.domain.repository.IHusnaRepository
import com.muhammadfiqrit.quranku.core.domain.repository.ILokasiRepository
import com.muhammadfiqrit.quranku.core.domain.repository.IQuoteRepository
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
        Room.databaseBuilder(androidContext(), SuratDatabase::class.java, "surat.db")
            .fallbackToDestructiveMigration().build()
    }

    factory {
        get<LokasiDatabase>().lokasiDao()
    }
    single {
        Room.databaseBuilder(androidContext(), LokasiDatabase::class.java, "lokasi.db")
            .fallbackToDestructiveMigration().build()
    }

    factory {
        get<HusnaDatabase>().asmaulHusnaDao()
    }
    single {
        Room.databaseBuilder(androidContext(), HusnaDatabase::class.java, "husna.db")
            .fallbackToDestructiveMigration().build()
    }
    factory { get<DoaDatabase>().doaDao() }
    single {
        Room.databaseBuilder(androidContext(), DoaDatabase::class.java, "doa.db")
            .fallbackToDestructiveMigration().build()
    }
    factory { get<HaditsDatabase>().haditsDao() }
    single {
        Room.databaseBuilder(androidContext(), HaditsDatabase::class.java, "hadits.db")
            .fallbackToDestructiveMigration().build()
    }
}
val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    //surat
    single {
        val retrofitSurat = Retrofit.Builder()
            .baseUrl(BASE_URL_SURAT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofitSurat.create(SuratService::class.java)
    }

    //sholat
    single {
        val retrofitSolat = Retrofit.Builder()
            .baseUrl(BASE_URL_SHOLAT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofitSolat.create(SholatService::class.java)
    }

    //lokasi
    single {
        val retrofitLokasi = Retrofit.Builder()
            .baseUrl(BASE_URL_SHOLAT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofitLokasi.create(LokasiService::class.java)
    }

    //asmaul husna
    single {
        val retrofitAsmaulHusna = Retrofit.Builder()
            .baseUrl(BASE_URL_SHOLAT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofitAsmaulHusna.create(AsmaulHusnaService::class.java)
    }

    //Doa
    single {
        val retrofitDoa = Retrofit.Builder()
            .baseUrl(BASE_URL_SHOLAT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofitDoa.create(DoaService::class.java)
    }

    //hadits
    single {
        val retrofitHadits = Retrofit.Builder()
            .baseUrl(BASE_URL_SHOLAT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofitHadits.create(HaditsService::class.java)
    }
}

val repositoryModule = module {
    factory { AppExecutors() }


    single<ISuratRepository> {
        SuratRepository(
            get(),
            get(),
            get()
        )
    }
    single<ILokasiRepository> {
        LokasiRepository(get(), get(), get())
    }
    single<ISholatRepository> { SholatRepository(get(), get()) }
    single<IHusnaRepository> { HusnaRepository(get(), get(), get()) }
    single<IDoaRepository> { DoaRepository(get(), get(), get()) }
    single<IHaditsRepository> { HaditsRepository(get(), get(), get()) }
    single<IQuoteRepository> { QuoteRepository() }

    single { SuratLocalDataSource(get()) }
    single { LokasiRemoteDataSource(get()) }
    single { LokasiLocalDataSource(get()) }
    single { SholatRemoteDataSource(get()) }
    single { SuratRemoteDataSource(get()) }
    single { HusnaRemoteDataSource(get()) }
    single { HusnaLocalDataSource(get()) }
    single { DoaRemoteDataSource(get()) }
    single { DoaLocalDataSource(get()) }
    single { HaditsRemoteDataSource(get()) }
    single { HaditsLocalDataSource(get()) }


}