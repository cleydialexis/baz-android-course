package com.example.criptos.data.models.CoinTiketDTO.tickerquery


data class Payload(
    val ask: String,
    val bid: String,
    val book: String,
    val change_24: String,
    val created_at: String,
    val high: String,
    val last: String,
    val low: String,
    val volume: String,
    val vwap: String
)
