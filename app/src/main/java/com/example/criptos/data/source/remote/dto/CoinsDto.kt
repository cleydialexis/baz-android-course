package com.example.cripto.data.source.remote.dto

import com.example.cripto.domain.model.Coins

data class CoinsDto(
    val payload: List<Payload>,
    val success: Boolean
)

fun CoinsDto.toListCoins(): List<Coins>{
    val resultEntries = payload.mapIndexed{ _, entries ->
        Coins(
            book = entries.book,
            maximum_amount = entries.maximum_amount,
            maximum_price= entries.maximum_price,
            maximum_value= entries.maximum_value,
            minimum_amount= entries.minimum_amount,
            minimum_price= entries.minimum_price,
            minimum_value= entries.minimum_value
        )
    }
        return resultEntries

}