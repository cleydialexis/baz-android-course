package com.example.cripto.data.source.remote


import com.example.cripto.data.source.remote.dto.CoinsDto
import retrofit2.http.GET


interface ApiService {
    @GET("v3/available_books/")
    suspend fun getAvailableBooks(): CoinsDto
}