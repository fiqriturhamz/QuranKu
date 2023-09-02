package com.muhammadfiqrit.quranku.data

import android.provider.ContactsContract.RawContacts.Data
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.muhammadfiqrit.quranku.data.source.local.LocalDataSource
import com.muhammadfiqrit.quranku.data.source.local.entity.SuratEntity
import com.muhammadfiqrit.quranku.data.source.remote.RemoteDataSource
import com.muhammadfiqrit.quranku.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.data.source.remote.response.SuratResponse
import com.muhammadfiqrit.quranku.domain.model.Surat
import com.muhammadfiqrit.quranku.domain.repository.ISuratRepository
import com.muhammadfiqrit.quranku.utils.AppExecutors
import com.muhammadfiqrit.quranku.utils.DataMapper

class SuratRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISuratRepository {
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

   override fun getAllSurat(): LiveData<Resource<List<Surat>>> =
        object : NetworkBoundResource<List<Surat>, List<SuratResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Surat>> {
                return Transformations.map(localDataSource.getAllSurat()){
                    DataMapper.mapEntityToDomain(it)
                }
            }

            override fun createCall(): LiveData<ApiResponse<List<SuratResponse>>> =
                remoteDataSource.getAllSurat()


            override fun saveCallResult(data: List<SuratResponse>) {
                val suratList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertSurat(suratList)
            }

            override fun shouldFetch(data: List<Surat>?): Boolean =
                data == null || data.isEmpty()

        }.asLiveData()


}