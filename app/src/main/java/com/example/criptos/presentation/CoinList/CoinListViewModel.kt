package com.example.criptos.presentation.CoinList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptos.domain.model.Book
import com.example.criptos.util.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinsUseCase: CoinListUseCase
) :ViewModel(){

    private val coinListValue = MutableStateFlow(CoinListState())
    var _coinListValue : StateFlow<CoinListState> = coinListValue

    fun getAllCoins()=viewModelScope.launch(Dispatchers.IO){
        coinsUseCase().collect {
            when(it){
                is ResponseState.Success ->{
                    coinListValue.value = CoinListState(coinsList = it.data as List<Book>)
                }
                is ResponseState.Loading ->{
                    coinListValue.value = CoinListState(isLoading = true)
                }
                is ResponseState.Error ->{
                    coinListValue.value = CoinListState(error = it.message?:"An Unexpected Error")
                }
            }
        }
    }
}