package com.example.criptos.domain.use_case

import com.example.criptos.domain.model.Order
import com.example.criptos.domain.repository.CoinRepository
import com.example.criptos.util.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinOrderUseCase (
    private  val repository: CoinRepository
    ) {
        operator fun invoke(): Flow<ResponseState<List<Order>>> = flow {
            try {
                emit(ResponseState.Loading<List<Order>>())
                val orders = repository.getCoinOrder().map {
                    it.toOrder()
                }
         //       emit(ResponseState.Success<List<Order>>(orders))
            } catch (e: HttpException) {
                emit(ResponseState.Error<List<Order>>(e.localizedMessage ?: "An Unexpected Error"))
            } catch (e: IOException) {
                emit(ResponseState.Error<List<Order>>("Internet Error"))
            }
        }
}
