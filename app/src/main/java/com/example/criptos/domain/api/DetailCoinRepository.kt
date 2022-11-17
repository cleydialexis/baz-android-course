package com.example.criptos.domain.api

import com.example.criptos.data.models.CoinOrderDTO.OrderBooks
import com.example.criptos.domain.repository.model.BookDetail


interface DetailCoinRepository {
    suspend fun getDetailCoin(typeCoin: String): BookDetail
    suspend fun getLocalDetailCoin(typeCoin: String): BookDetail
    suspend fun getBidsAsksCoin(typeCoin: String): OrderBooks
    suspend fun getLocalBidsAsksCoin(): List<OrderBooks>
    suspend fun insertLocalDetailBook(bookDetail: BookDetail)
}