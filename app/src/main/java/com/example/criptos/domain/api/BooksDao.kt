package com.example.criptos.domain.api

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.criptos.domain.model.Book
import com.example.criptos.domain.model.BookDetail
import com.example.criptos.domain.repository.model.Book

@Dao
interface BooksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllBooks(book: List<Book>)

    @Query("SELECT * FROM Book")
    fun getAvailableLocalBooks(): List<Book>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertLocalDetailBooks(typeCoin: BookDetail)

    @Query("SELECT * FROM BookDetail WHERE book = :book")
    fun getLocalDetailBooks(book: String): BookDetail

}