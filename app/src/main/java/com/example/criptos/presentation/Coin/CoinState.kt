package com.example.criptos.presentation.Coin

import com.example.criptos.domain.model.BookDetail

data class CoinState(
    val isLoading : Boolean = false,
    val coinDetail : BookDetail? =null,
    val error : String = ""
)