package com.example.criptos.domain.api


import com.example.criptos.data.models.CoinListDTO.CoinListDto
import com.example.criptos.data.models.CoinTiketDTO.tickerquery.TickerWith
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v3/available_books/")
    suspend fun getAvailableBooks(): CoinListDto

    @GET("v3/order_book/")
    suspend fun getOrderBooks(
        @Query("book")
        book: String
    ): CoinOrderDto

    @GET("v3/ticker/")
    suspend fun getTicker(
        @Query("book")
        book: String
    ): TickerWith

}
