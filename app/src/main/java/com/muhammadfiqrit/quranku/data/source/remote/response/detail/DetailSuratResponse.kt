package com.muhammadfiqrit.quranku.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.muhammadfiqrit.quranku.data.source.remote.response.detail.DataDetailSuratResponse

data class DetailSuratResponse(

    @field:SerializedName("code")
	val code: Int? = null,

    @field:SerializedName("data")
	val data: DataDetailSuratResponse? =null,

    @field:SerializedName("message")
	val message: String? = null
)





