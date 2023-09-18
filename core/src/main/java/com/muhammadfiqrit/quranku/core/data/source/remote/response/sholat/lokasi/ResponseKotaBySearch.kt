package com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi

import com.google.gson.annotations.SerializedName

data class ResponseKotaBySearch(

	@field:SerializedName("data")
	val data: List<ResponseKotaItem>,

	@field:SerializedName("status")
	val status: Boolean
)

