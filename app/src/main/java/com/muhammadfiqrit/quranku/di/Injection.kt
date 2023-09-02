package com.muhammadfiqrit.quranku.di

import android.content.Context
import com.muhammadfiqrit.quranku.data.SuratRepository
import com.muhammadfiqrit.quranku.data.source.local.LocalDataSource
import com.muhammadfiqrit.quranku.data.source.local.room.SuratDatabase
import com.muhammadfiqrit.quranku.data.source.remote.RemoteDataSource
import com.muhammadfiqrit.quranku.data.source.remote.network.ApiConfig
import com.muhammadfiqrit.quranku.utils.AppExecutors
import java.util.Locale

object Injection {
    fun provideRepository(context : Context) : SuratRepository{
        val database = SuratDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.suratDao())
        val appExecutors = AppExecutors()
        return  SuratRepository.getInstance(remoteDataSource,localDataSource,appExecutors)
    }
}