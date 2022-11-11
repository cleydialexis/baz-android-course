package com.example.criptos.data.data_source.dto.CoinOrderDTO

import com.example.criptos.domain.model.Ask
import com.example.criptos.domain.model.Bid
import com.example.criptos.domain.model.Order

class CoinOrderDtoItem (val Order: Order,
                        val success: Boolean,
                        val asks: List<Ask>,
                        val bids: List<Bid>,
                        val sequence: String,
                        val updated_at: String

){

    fun toOrder(): Order {
        return Order(
            asks= asks,
        bids= bids,
        sequence= sequence,
        updated_at= updated_at

        )
    }
}
