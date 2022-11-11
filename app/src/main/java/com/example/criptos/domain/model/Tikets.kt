package com.example.criptos.domain.model

data class Tiket(
    val ask: String,
    val bid: String,
    val book: String,
    val created_at: String,
    val high: String,
    val last: String,
    val low: String,
    val volume: String,
    val vwap: String
)