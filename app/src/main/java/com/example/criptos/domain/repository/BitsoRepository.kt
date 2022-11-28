package com.example.criptos.domain.repository

import com.example.criptos.data.models.response.AvailableBooksResponse
import com.example.criptos.domain.repository.model.AvailableBook
import com.example.criptos.domain.repository.model.OrderBook
import com.example.criptos.domain.repository.model.Ticker
import io.reactivex.rxjava3.core.Single

interface BitsoRepository {
    suspend fun getAvailableBooks(): List<AvailableBook>
    suspend fun getTicker(book: String): Ticker
    suspend fun getOrderBook(book: String): OrderBook
    fun getAvailableBooksRxJava(): io.reactivex.Single<AvailableBooksResponse>
}