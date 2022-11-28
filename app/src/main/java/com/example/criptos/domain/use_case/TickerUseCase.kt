package com.example.criptos.domain.use_case

import com.example.criptos.data.database.di.RequestState
import com.example.criptos.domain.repository.BitsoRepository

import com.example.criptos.domain.repository.model.Ticker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TickerUseCase @Inject constructor(private val repository: BitsoRepository) {

    operator fun invoke(book: String): Flow<RequestState<Ticker>> = flow {
        try {
            emit(RequestState.Loading())
            val response = repository.getTicker(book)

            emit(RequestState.Success(response))
        } catch (e: HttpException) {
            emit(RequestState.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(RequestState.Error("Couldn't reach server."))
        }
    }
}