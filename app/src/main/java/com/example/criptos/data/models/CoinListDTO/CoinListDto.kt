package com.example.criptos.data.models.CoinListDTO

import java.io.Serializable


data class CoinListDto(
    val payload: List<Payload>,
    val  success: Boolean
) : Serializable