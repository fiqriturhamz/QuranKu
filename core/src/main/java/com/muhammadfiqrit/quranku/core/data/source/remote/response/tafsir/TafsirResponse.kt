package com.muhammadfiqrit.quranku.core.data.source.remote.response.tafsir

import com.google.gson.annotations.SerializedName

data class TafsirResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: ListTafsirResponse,

	@field:SerializedName("message")
	val message: String
)




