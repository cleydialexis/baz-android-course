package com.example.criptos.data.models.orderbook

import com.example.criptos.data.models.OpenOrder.OpenOrderDto
import com.example.criptos.domain.repository.model.OpenOrder
import com.example.criptos.domain.repository.model.OrderBook
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class OrderBookDto(
    @SerializedName("asks")
    @Expose
    var asks: List<OpenOrderDto>? = null,
    @SerializedName("bids")
    @Expose
    var bids: List<OpenOrderDto>? = null,
    @SerializedName("updated_at")
    @Expose
    var updated_at: Date? = null,
    @SerializedName("sequence")
    @Expose
    var sequence: String? = null
) {
    private fun List<OpenOrderDto>?.toOrderBookList(): List<OpenOrder> =
        this?.map { it.toOpenOrder() } ?: emptyList()

    fun toOrderBook(book: String): OrderBook =
        OrderBook(
            book = book,
            asks = asks.toOrderBookList(),
            bids = bids.toOrderBookList()
        )
}