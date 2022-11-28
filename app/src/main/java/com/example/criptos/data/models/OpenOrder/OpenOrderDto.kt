package com.example.criptos.data.models.OpenOrder

import com.example.criptos.data.utils.formatAsCurrency
import com.example.criptos.domain.repository.model.OpenOrder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OpenOrderDto(
    @SerializedName("book")
    @Expose
    var book: String? = null,
    @SerializedName("price")
    @Expose
    var price: Double? = null,
    @SerializedName("amount")
    @Expose
    var amount: Double? = null
) {
    fun toOpenOrder(): OpenOrder =
        OpenOrder(
            book = book,
            price = price?.formatAsCurrency(),
            amount = amount?.toString()
        )
}