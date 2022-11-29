package com.example.criptos.domain.repository.model

class OrderBook(
    var book: String? = null,
    var asks: List<OpenOrder>? = null,
    var bids: List<OpenOrder>? = null
)