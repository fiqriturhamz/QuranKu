package com.muhammadfiqrit.quranku

import android.app.Application
import com.muhammadfiqrit.quranku.data.di.databaseModule
import com.muhammadfiqrit.quranku.data.di.networkModule
import com.muhammadfiqrit.quranku.data.di.repositoryModule
import com.muhammadfiqrit.quranku.di.useCaseModule
import com.muhammadfiqrit.quranku.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}