package com.example.cripto


import com.example.cripto.data.source.remote.dto.CoinsDto


interface RemoteDataSource {

   suspend fun getAvailableBooks(): CoinsDto
}