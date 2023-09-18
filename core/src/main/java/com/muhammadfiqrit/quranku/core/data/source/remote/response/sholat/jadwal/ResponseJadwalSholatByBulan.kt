package com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.jadwal

import com.google.gson.annotations.SerializedName

data class ResponseJadwalSholatByBulan(

    @field:SerializedName("data")
	val data: ResponseJadwalDataBulan,

    @field:SerializedName("status")
	val status: Boolean
)



