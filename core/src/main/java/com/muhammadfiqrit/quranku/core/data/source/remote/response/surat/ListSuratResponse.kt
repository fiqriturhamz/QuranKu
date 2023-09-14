package com.muhammadfiqrit.quranku.core.data.source.remote.response.surat

import com.google.gson.annotations.SerializedName

data class ListSuratResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<SuratResponse>,

	@field:SerializedName("message")
	val message: String? = null
)



