package com.example.criptos.data.data_source


import com.example.criptos.data.data_source.dto.CoinListDTO.CoinListDto
import com.example.criptos.data.data_source.dto.CoinDetailDTO.CoinDetailDto
import com.example.criptos.data.data_source.dto.CoinOrderDTO.CoinOrderDto
import com.example.criptos.data.data_source.dto.CoinTiketDTO.CoinTiketDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoApi {

    @GET("v3/available_books/")
    suspend fun getAllCoins(): CoinListDto

  //  @GET("v3/ticker/2")
  //  suspend fun getCoinById(@Path("id")id:String): CoinDetailDto

    @GET("v3/ticker/")
    suspend fun getCoinTikets(): CoinTiketDto

    @GET("v3/order_book/")
    suspend fun getCoinOrders(): CoinOrderDto
}
