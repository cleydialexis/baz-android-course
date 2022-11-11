package com.example.criptos.data.data_source.dto.CoinTiketDTO

import com.example.criptos.domain.model.Tiket


data class CoinTiketDtoItem(
    val payload: Tiket,
    val success: Boolean,
    val ask: String,
    val bid: String,
    val book: String,
    val created_at: String,
    val high: String,
    val last: String,
    val low: String,
    val volume: String,
    val vwap: String
) {
    fun toTiket(): Tiket {
        return Tiket(
         ask = ask,
         bid = bid,
         book = book,
         created_at = created_at,
         high = high,
         last = last,
         low = low,
         volume = volume,
         vwap = vwap

        )
    }
    }




