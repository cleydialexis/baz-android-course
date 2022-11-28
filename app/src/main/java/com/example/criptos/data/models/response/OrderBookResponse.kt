package com.example.criptos.data.models.response

import com.example.criptos.data.models.orderbook.OrderBookDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OrderBookResponse(
    @SerializedName("success")
    @Expose
    var success: Boolean? = null,
    @SerializedName("payload")
    @Expose
    var payload: OrderBookDto? = null
)