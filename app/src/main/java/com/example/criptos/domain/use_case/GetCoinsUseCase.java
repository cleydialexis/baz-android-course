package com.example.criptos.domain.use_case;

import com.example.cripto.data.Result;
import com.example.cripto.domain.model.Coins;
import com.example.cripto.domain.repositories.CoinRepository;

import java.util.List;

import javax.inject.Inject;

import kotlinx.coroutines.flow.Flow;
/*
class GetCoinsUseCase @Inject constructor(
        private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Result<List<Coins>>>{
        return repository.getCoins()
    }
}
*/