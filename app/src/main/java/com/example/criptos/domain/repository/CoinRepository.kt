package com.example.criptos.domain.repository


import com.example.criptos.data.models.CoinTiketDTO.CoinTiketDto
import com.example.criptos.domain.model.Book

interface CoinRepository {

    suspend fun getAllCoins(): List<Book>

  //  suspend fun getCoinById(id:String): CoinDetailDto

    suspend fun getCoinTikesId(): CoinTiketDto

    suspend fun getCoinOrder(): CoinOrderDto


}