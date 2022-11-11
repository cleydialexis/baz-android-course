package com.example.criptos.presentation.CoinList

import com.example.criptos.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coinsList : List<Coin> = emptyList(),
    val error : String = ""
)
