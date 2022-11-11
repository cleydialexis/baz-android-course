package com.example.criptos.data.data_source.dto.CoinListDTO


import com.example.criptos.domain.model.Coin

data class CoinListDtoItem(
    val book: String,
    val maximum_amount: String,
    val maximum_price: String,
    val maximum_value: String,
    val minimum_amount: String,
    val minimum_price: String,
    val minimum_value: String,
    val success: Boolean
){
    fun toCoin(): Coin {
        return Coin(
            book = book,
            maximum_amount= maximum_amount,
            maximum_price = maximum_price,
            maximum_value = maximum_value,
            minimum_amount = minimum_amount,
            minimum_price = minimum_price,
            minimum_value = minimum_value

        )
    }
}