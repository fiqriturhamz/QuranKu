package com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.jadwal

import com.google.gson.annotations.SerializedName

data class ResponseJadwalSholatByHari(

	@field:SerializedName("data")
	val data: ResponseJadwalDataHarian,

	@field:SerializedName("status")
	val status: Boolean
)




