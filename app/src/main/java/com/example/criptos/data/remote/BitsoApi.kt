package com.example.criptos.data.remote

import com.example.criptos.data.models.response.AvailableBooksResponse
import com.example.criptos.data.models.response.OrderBookResponse
import com.example.criptos.data.models.response.TickerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface BitsoApi {

    @GET("available_books")
    suspend fun getAvaliableBooks(): AvailableBooksResponse

    @GET("ticker/")
    suspend fun getTicker(
        @Query("book") book: String,
    ): TickerResponse

    @GET("order_book/")
    suspend fun getOrderBook(
        @Query("book") book: String
    ): OrderBookResponse

    @GET("available_books")
    fun getAvailableBooksRxJava(): Single<AvailableBooksResponse>
}