package com.example.criptos.data.models.response

import com.example.criptos.data.models.CoinTiketDTO.TickerDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TickerResponse(
    @SerializedName("success")
    @Expose
    var success: Boolean? = null,
    @SerializedName("payload")
    @Expose
    var payload: TickerDto? = null
)