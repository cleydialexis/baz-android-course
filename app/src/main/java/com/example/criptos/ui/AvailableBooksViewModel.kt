package com.example.criptos.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptos.data.database.di.RequestState
import com.example.criptos.data.models.response.toMXNAvailableBookList
import com.example.criptos.domain.repository.model.AvailableBook
import com.example.criptos.domain.use_case.AvailableBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@HiltViewModel
class AvailableBooksViewModel @Inject constructor(
    private val availableBooksUseCase: AvailableBooksUseCase,
) : ViewModel() {

    private val _availableOrderBookList = MutableLiveData<List<AvailableBook>>()
    private val _isLoading = MutableLiveData<Boolean>(true)
    private val _error = MutableLiveData<String>()

    val availableOrderBookList: LiveData<List<AvailableBook>> get() = _availableOrderBookList
    val isLoading: LiveData<Boolean> get() = _isLoading
    val error: LiveData<String> get() = _error

    private val defaultScheduler: Scheduler = Schedulers.io()
    private val compositeDisposable:CompositeDisposable= CompositeDisposable()

    fun getAvailableBooksRxJava() = MutableLiveData<List<AvailableBook>>().apply {
        compositeDisposable.add(
            availableBooksUseCase.availableBooksRx()
                .subscribeOn(defaultScheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        with(it?.payload.toMXNAvailableBookList()) {
                            if (this.isNullOrEmpty()) _error.value ="No stored data"
                            _availableOrderBookList.postValue(this)
                        }
                    },
                    onError = {
                        _error.value =it.message.orEmpty()
                    },
                )
        )
    }

    fun getAvailableBooks() {
        availableBooksUseCase().onEach {
            when (it) {
                is RequestState.Loading -> _isLoading.value = true
                is RequestState.Success -> {
                    _availableOrderBookList.value = it.data ?: emptyList()
                    _isLoading.value = false
                }
                is RequestState.Error -> {
                    _error.value = it.message.toString()
                    _isLoading.value = false
                }
            }
        }.launchIn(viewModelScope)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
    }
}