package com.example.criptos.data.repository

import com.example.criptos.domain.api.ApiService
import com.example.criptos.domain.api.BooksDao
import com.example.criptos.domain.api.CoinsRepository
import com.example.criptos.domain.repository.model.Book
import com.example.criptos.util.toBooks
import javax.inject.Inject

class CoinsRepositoryImpl @Inject constructor(
private val api: ApiService,
private val dao: BooksDao
) : CoinsRepository {
    override suspend fun getAvailableBooks(): List<Book> =
        api.getAvailableBooks().toBooks()

    override suspend fun insertLocalBooks(book: List<Book>) =
        dao.insertAllBooks(book)

    override suspend fun getLocalBooks(): List<Book> =
        dao.getAvailableLocalBooks()



}
