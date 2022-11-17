package com.example.criptos.presentation.CoinList

import com.example.criptos.domain.model.Book

data class CoinListState(
    val isLoading : Boolean = false,
    val coinsList : List<Book> = emptyList(),
    val error : String = ""
)
