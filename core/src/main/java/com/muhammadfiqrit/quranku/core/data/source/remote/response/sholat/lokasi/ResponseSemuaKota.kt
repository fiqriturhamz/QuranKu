package com.muhammadfiqrit.quranku.core.data.source.remote.response.sholat.lokasi

import com.google.gson.annotations.SerializedName

data class ResponseSemuaKota(

	@field:SerializedName("ResponseSemuaKota")
	val responseSemuaKota: List<ResponseKotaItem>
)

