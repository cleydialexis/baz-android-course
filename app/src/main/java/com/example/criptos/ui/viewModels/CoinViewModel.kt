package com.example.criptos.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.criptos.domain.repository.model.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoinViewModel @Inject constructor(private var useCase: AvailableBooksUseCase) : ViewModel() {
    val cryptoBook = MutableLiveData<List<Book>>()

    fun getAvailableBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = useCase.book()
            response.collect { books ->
                cryptoBook.postValue(books)
            }
        }
    }

}

class ViewModelFactory(private val availableUseCase: AvailableBooksUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoinViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CoinViewModel(availableUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}