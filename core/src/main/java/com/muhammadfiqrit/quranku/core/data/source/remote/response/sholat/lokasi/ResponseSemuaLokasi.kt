package com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi

import com.google.gson.annotations.SerializedName

data class ResponseSemuaLokasi(

	@field:SerializedName("data")
	val data: List<ResponseSemuaLokasiItem>,

	@field:SerializedName("status")
	val status: Boolean
)


