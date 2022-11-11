package com.example.criptos.presentation.Tiket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptos.domain.use_case.CoinListUseCase
import com.example.criptos.presentation.CoinList.CoinListState
import com.example.criptos.util.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinTViewModel @Inject constructor(
    private val coinsUseCase: CoinListUseCase
) :ViewModel(){

    private val coinTiketValue = MutableStateFlow(CoinListState())
    var _coinTiketsValue : StateFlow<CoinListState> = coinTiketValue

    fun getCoinTikets()=viewModelScope.launch(Dispatchers.IO){
        coinsUseCase().collect {
            when(it){
                is ResponseState.Success ->{
                    coinTiketValue.value = CoinListState(coinsList = it.data?: emptyList())
                }
                is ResponseState.Loading ->{
                    coinTiketValue.value = CoinListState(isLoading = true)
                }
                is ResponseState.Error ->{
                    coinTiketValue.value = CoinListState(error = it.message?:"An Unexpected Error")
                }
            }
        }
    }
}