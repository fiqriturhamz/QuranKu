package com.muhammadfiqrit.quranku.data

import androidx.lifecycle.LiveData
import com.muhammadfiqrit.quranku.data.source.local.LocalDataSource
import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.remote.RemoteDataSource
import com.muhammadfiqrit.quranku.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.SuratResponse
import com.muhammadfiqrit.quranku.utils.AppExecutors
import com.muhammadfiqrit.quranku.utils.DataMapper

class SuratRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) {
    companion object {
        @Volatile
        private var instance: SuratRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): SuratRepository = instance ?: synchronized(this) {
            instance ?: SuratRepository(remoteData, localData, appExecutors)
        }
    }

    fun getAllSurat(): LiveData<Resource<List<SuratEntity>>> =
        object : NetworkBoundResource<List<SuratEntity>, List<SuratResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<SuratEntity>> {
                return localDataSource.getAllSurat()
            }

            override fun createCall(): LiveData<ApiResponse<List<SuratResponse>>> =
                remoteDataSource.getAllSurat()


            override fun saveCallResult(data: List<SuratResponse>) {
                val suratList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertSurat(suratList)
            }

            override fun shouldFetch(data: List<SuratEntity>?): Boolean =
                data == null || data.isEmpty()

        }.asLiveData()
}