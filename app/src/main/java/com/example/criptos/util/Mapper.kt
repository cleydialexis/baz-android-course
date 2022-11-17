package com.example.criptos.util

import com.example.criptos.data.models.CoinListDTO.CoinListDto
import com.example.criptos.data.models.CoinTiketDTO.Payload
import com.example.criptos.data.models.CoinTiketDTO.tickerquery.TickerWith
import com.example.criptos.domain.repository.model.Book
import com.example.criptos.domain.repository.model.BookDetail

fun CoinListDto.toBooks(): List<Book> =
    this.payload.map {
        it.toBook()
    }

fun TickerWith.toDetail() =
    BookDetail(
        id = 0,
        book = this.payload.book,
        high = this.payload.high,
        last = this.payload.last,
        low = this.payload.low,
    )

fun Payload.toBook() = Book(id = book, idBook = 0)