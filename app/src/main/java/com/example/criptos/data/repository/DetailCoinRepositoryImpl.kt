package com.example.criptos.data.repository

import com.example.criptos.domain.api.ApiService
import com.example.criptos.data.models.CoinOrderDTO.OrderBooks
import com.example.criptos.domain.api.BooksDao
import com.example.criptos.domain.api.DetailCoinRepository
import com.example.criptos.domain.repository.model.BookDetail
import com.example.criptos.util.toDetail
import javax.inject.Inject

class DetailCoinRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: BooksDao
) :
    DetailCoinRepository {
    override suspend fun getDetailCoin(typeCoin: String): BookDetail =
        api.getTicker(typeCoin).toDetail()

    override suspend fun getLocalDetailCoin(typeCoin: String): BookDetail =
        dao.getLocalDetailBooks(typeCoin)

    override suspend fun getBidsAsksCoin(typeCoin: String): OrderBooks =
        api.getOrderBooks(typeCoin)

    override suspend fun getLocalBidsAsksCoin(): List<OrderBooks> {
        TODO("Not yet implemented")
    }

    override suspend fun insertLocalDetailBook(bookDetail: BookDetail) =
        dao.insertLocalDetailBooks(bookDetail)
}