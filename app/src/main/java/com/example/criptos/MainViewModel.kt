package com.example.cripto


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cripto.data.ApiRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel (
    private val repository: ApiRepository
        ) : ViewModel() {


    private val compositeDisposable = CompositeDisposable()

      fun getAvailableBooks() = viewModelScope.launch(Dispatchers.IO){
        val result= repository.getBook()
        Log.i("MainActivity", result.payload.toString())
    }


}
class MainViewModelFactory(private val repository: ApiRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ApiRepository::class.java).newInstance(repository)
    }
}