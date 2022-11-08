package com.example.cripto.domain.repositories

import com.example.cripto.domain.model.Coin
import com.example.cripto.domain.model.Coins
import kotlinx.coroutines.flow.Flow


interface CoinRepository {
    fun getCoins(): Flow<Result<List<Coins>>>

    suspend fun getCoin(): Flow<Result<List<Coin>>>
}