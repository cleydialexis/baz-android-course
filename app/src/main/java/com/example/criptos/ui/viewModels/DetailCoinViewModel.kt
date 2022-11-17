package com.example.criptos.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.criptos.data.models.CoinOrderDTO.OrderBooks
import com.example.criptos.domain.repository.model.BookDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailCoinViewModel @Inject constructor(private var useCase: DetailCoinUseCase) :
    ViewModel() {
    val detailCoin = MutableLiveData<BookDetail>()
    val bidsAsksCoin = MutableLiveData<OrderBooks>()

    fun getDetailCoin(typeCoin: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = useCase.detailCoin(typeCoin)
            response.collect { detail ->
                detailCoin.postValue(detail)
            }
        }
    }

    fun getBidsAsksCoin(typeCoin: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = useCase.bidsAsksCoin(typeCoin)
            response.collect { ba ->
                bidsAsksCoin.postValue(ba)
            }
        }
    }

}

class ViewModelFactorym<DetailCoinUseCase>(private val detailUseCase: DetailCoinUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailCoinViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailCoinViewModel(detailUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}