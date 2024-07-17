package com.muhammadfiqrit.quranku.core.data.repository

import com.muhammadfiqrit.quranku.core.data.NetworkOnlyResource
import com.muhammadfiqrit.quranku.core.data.Resource
import com.muhammadfiqrit.quranku.core.data.source.remote.SholatRemoteDataSource
import com.muhammadfiqrit.quranku.core.data.source.remote.network.ApiResponse
import com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.jadwal.ResponseJadwalDataHarian
import com.muhammadfiqrit.quranku.core.domain.model.sholat.jadwal.JadwalDataHarian
import com.muhammadfiqrit.quranku.core.domain.repository.ISholatRepository
import com.muhammadfiqrit.quranku.core.utils.AppExecutors
import com.muhammadfiqrit.quranku.core.utils.DataMapperSholat
import kotlinx.coroutines.flow.Flow

class SholatRepository(
    private val sholatRemoteDataSource: SholatRemoteDataSource,
    private val appExecutors: AppExecutors
) : ISholatRepository {
    override fun getJadwalSholatPerHari(tanggal: String, idKota : Int): Flow<Resource<JadwalDataHarian>> {
        return object : NetworkOnlyResource<JadwalDataHarian, ResponseJadwalDataHarian>() {
            override fun loadFromNetwork(data: ResponseJadwalDataHarian): Flow<JadwalDataHarian> {
                return DataMapperSholat.responseJadwalDataHarianToJadwalDataHarian(data)
            }


            override suspend fun createCall(): Flow<ApiResponse<ResponseJadwalDataHarian>> {
                return sholatRemoteDataSource.getJadwalSholatPerHari(tanggal, idKota)
            }

        }.asFlow()
    }

}