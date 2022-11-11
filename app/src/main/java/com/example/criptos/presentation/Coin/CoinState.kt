package com.example.criptos.presentation.Coin

import com.example.criptos.domain.model.CoinDetail

data class CoinState(
    val isLoading : Boolean = false,
    val coinDetail : CoinDetail? =null,
    val error : String = ""
)