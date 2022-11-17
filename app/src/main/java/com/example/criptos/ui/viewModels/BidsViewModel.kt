package com.example.criptos.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.criptos.data.models.CoinOrderDTO.OrderBooks

class BidsViewModel : ViewModel(){
    val bidsCoin = MutableLiveData<OrderBooks>()

}