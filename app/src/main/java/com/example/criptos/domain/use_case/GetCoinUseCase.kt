package com.example.cripto.domain.use_case



import com.example.cripto.domain.model.Coin
import com.example.cripto.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

abstract class GetCoinUseCase @Inject constructor(
    private val repository : CoinRepository
) {
    suspend operator fun invoke(): Flow<Result<List<Coin>>> {
        return repository.getCoin()
    }
}