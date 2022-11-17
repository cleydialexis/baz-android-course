package com.example.criptos.domain.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.criptos.data.models.CoinOrderDTO.Payload
import com.example.criptos.domain.api.BooksDao
import com.example.criptos.domain.repository.model.Book
import com.example.criptos.domain.repository.model.BookDetail

@Database(entities = [Payload::class, Book::class, BookDetail::class], version = 1)
abstract class BooksDB : RoomDatabase() {
    abstract fun CoinsDao(): BooksDao
}