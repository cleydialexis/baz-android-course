package com.example.criptos.domain.repository


import com.example.criptos.data.data_source.dto.CoinListDTO.CoinListDto
import com.example.criptos.data.data_source.dto.CoinOrderDTO.CoinOrderDto
import com.example.criptos.data.data_source.dto.CoinTiketDTO.CoinTiketDto

interface CoinRepository {

    suspend fun getAllCoins(): CoinListDto

  //  suspend fun getCoinById(id:String): CoinDetailDto

    suspend fun getCoinTikesId(): CoinTiketDto

    suspend fun getCoinOrder(): CoinOrderDto


}