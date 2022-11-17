package com.example.criptos.domain.use_case

import android.util.Log
import com.example.criptos.data.repository.CoinsRepositoryImpl
import com.example.criptos.domain.repository.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class AvailableCoinsUseCase
@Inject constructor(private var repository: CoinsRepositoryImpl) {
    lateinit var response: List<Book>

    suspend fun book(): Flow<List<Book>> = flow {
        try {
            if (repository.getAvailableBooks().isNotEmpty()) {
                response = repository.getLocalBooks()
            } else {
                response = repository.getAvailableBooks()
                repository.insertLocalDetailBook(response)
            }
            emit(response)
        } catch (e: HttpException) {
            Log.d("Mensaje", "Show Error: $e")
        }
    }
}