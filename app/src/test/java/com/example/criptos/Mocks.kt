package com.example.criptos

import com.example.criptos.domain.repository.model.AvailableBook
import com.example.criptos.ui.adapter.entities.toAvailableBookEntityList

val availableOrderBookObject = AvailableBook(
    book = "btc_mxn",
    minimum_value = "40000",
    maximum_value = "20000000",
)

val listAvailableOrderBooks = listOf(availableOrderBookObject, availableOrderBookObject)
val listAvailableOrderBooksEntities =
    listOf(availableOrderBookObject, availableOrderBookObject).toAvailableBookEntityList()