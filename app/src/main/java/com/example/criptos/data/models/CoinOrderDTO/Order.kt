package com.example.criptos.data.models.CoinOrderDTO

data class Order(

    val asks: List<Ask>,
    val bids: List<Bid>,
    val sequence: String,
    val updated_at: String

)
{

}
