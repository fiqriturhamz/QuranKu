package com.muhammadfiqrit.quranku.core.data.source.remote.response.surat

import com.google.gson.annotations.SerializedName

data class ResponseListSurat(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<ResponseSurat>,

	@field:SerializedName("message")
	val message: String? = null
)



