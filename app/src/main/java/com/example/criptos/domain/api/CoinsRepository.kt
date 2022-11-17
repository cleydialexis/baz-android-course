package com.example.criptos.domain.api


import com.example.criptos.domain.repository.model.Book

interface CoinsRepository {
    suspend fun getAvailableBooks(): List<Book>
    suspend fun insertLocalBooks(book: List<Book>)
    suspend fun getLocalBooks(): List<Book>
}