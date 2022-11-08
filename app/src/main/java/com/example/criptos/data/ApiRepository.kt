package com.example.cripto.data



import com.example.cripto.data.source.remote.dto.CoinsDto


interface ApiRepository {
   suspend fun getBook() : CoinsDto
}