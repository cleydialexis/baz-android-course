package com.example.criptos.domain.use_case


import com.example.criptos.data.database.di.RequestState
import com.example.criptos.data.models.response.AvailableBooksResponse
import com.example.criptos.domain.repository.BitsoRepository
import com.example.criptos.domain.repository.model.AvailableBook
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AvailableBooksUseCase @Inject constructor(private val repository: BitsoRepository) {

    operator fun invoke(): Flow<RequestState<List<AvailableBook>>> = flow {

        try {
            emit(RequestState.Loading<List<AvailableBook>>())

            val list = repository.getAvailableBooks()
            val filteredList = list.filter { it.book?.contains("mxn") ?: false }

            emit(RequestState.Success(filteredList))
        } catch (e: HttpException) {
            emit(RequestState.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(RequestState.Error("Couldn't reach server. Check your internet connection."))
        }
    }

    fun availableBooksRx(): io.reactivex.Single<AvailableBooksResponse> = repository.getAvailableBooksRxJava()
}
