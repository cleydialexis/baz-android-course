package com.example.criptos.data.repository

import com.example.criptos.data.data_source.CoinGeckoApi
import com.example.criptos.data.data_source.dto.CoinListDTO.CoinListDto
import com.example.criptos.data.data_source.dto.CoinOrderDTO.CoinOrderDto
import com.example.criptos.data.data_source.dto.CoinTiketDTO.CoinTiketDto
import com.example.criptos.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(

    private val api : CoinGeckoApi
) : CoinRepository {
    //all Coins
    override suspend fun getAllCoins(): CoinListDto {
        return api.getAllCoins()
    }
    //all Coins Tikets
    override suspend fun getCoinTikesId(): CoinTiketDto {
        return api.getCoinTikets()
    }

    override suspend fun getCoinOrder(): CoinOrderDto {
        return api.getCoinOrders()
    }


   // override suspend fun getCoinById(id: String): CoinDetailDto {
//
 //       return api.getCoinById(id=id)
  //  }




}
