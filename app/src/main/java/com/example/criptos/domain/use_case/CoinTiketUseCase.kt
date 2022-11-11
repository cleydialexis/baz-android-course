package com.example.criptos.domain.use_case


import com.example.criptos.domain.model.Tiket
import com.example.criptos.domain.repository.CoinRepository
import com.example.criptos.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinTiketUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<ResponseState<List<Tiket>>> = flow {
        try {
            emit(ResponseState.Loading<List<Tiket>>())
            val tikets = repository.getCoinTikesId().map {
                it.toTiket()
            }
            emit(ResponseState.Success<List<Tiket>>(tikets))
        } catch (e: HttpException) {
            emit(ResponseState.Error<List<Tiket>>(e.localizedMessage ?: "An Unexpected Error"))
        } catch (e: IOException) {
            emit(ResponseState.Error<List<Tiket>>("Internet Error"))
        }
    }
}