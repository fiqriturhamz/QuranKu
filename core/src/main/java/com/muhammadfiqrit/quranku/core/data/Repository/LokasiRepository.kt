package com.muhammadfiqrit.quranku.core.data.Repository

import com.muhammadfiqrit.quranku.core.data.NetworkBoundResource
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.data.source.local.LokasiLocalDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.LokasiRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi.ResponseSemuaLokasiItem
import com.muhammadfiqrit.quranku.core.domain.model.lokasi.Lokasi
import com.muhammadfiqrit.quranku.core.domain.repository.ILokasiRepository
import com.muhammadfiqrit.quranku.core.utils.AppExecutors
import com.muhammadfiqrit.quranku.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LokasiRepository(
    private val lokasiRemoteDataSource: LokasiRemoteDataSource,
    private val lokasiLocalDataSource: LokasiLocalDataSource,
    private val appExecutors: AppExecutors
) : ILokasiRepository {
    override fun getSemuaLokasi(): Flow<Resource<List<Lokasi>>> {
        return object : NetworkBoundResource<List<Lokasi>, List<ResponseSemuaLokasiItem>>() {
            override fun loadFromDB(): Flow<List<Lokasi>> {
                return lokasiLocalDataSource.getAllLokasi()
                    .map { DataMapper.mapLokasiEntitiesToListLokasi(it) }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<ResponseSemuaLokasiItem>>> {
                return lokasiRemoteDataSource.getSemuaLokasi()
            }

            override suspend fun saveCallResult(data: List<ResponseSemuaLokasiItem>) {
                val lokasiList = DataMapper.mapLokasiResponsesToLokasiEntities(data)
                lokasiLocalDataSource.insertLokasi(lokasiList)
            }

            override fun shouldFetch(data: List<Lokasi>?): Boolean {
                return data.isNullOrEmpty()
            }

        }.asFlow()
    }

    override fun getLokasiSekarang(): Flow<Lokasi> {
        return lokasiLocalDataSource.getLokasiSekarang()
            .map { DataMapper.mapLokasiEntityToLokasi(it) }
    }

    override fun setLokasiSekarang(lokasi: Lokasi, state: Boolean) {
        val lokasiEntity = DataMapper.mapDomainLokasiToLokasiEntity(lokasi)
        appExecutors.diskIO()
            .execute { lokasiLocalDataSource.setLokasiSekarang(lokasiEntity, state) }
    }

}


