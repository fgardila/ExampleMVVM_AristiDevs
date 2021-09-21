package com.example.examplemvvm_aristidevs.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm_aristidevs.domain.model.QuoteModel
import com.example.examplemvvm_aristidevs.domain.GetQuotesUseCase
import com.example.examplemvvm_aristidevs.domain.GetRandomQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    val getRandomQuotesUseCase = GetRandomQuotesUseCase()

    fun randomQuote() {
        isLoading.postValue(true)
        //val currentQuote = QuoteProvider.random()
        //quoteModel.postValue(currentQuote)

        val quote = getRandomQuotesUseCase()
        if (quote != null) {
            quoteModel.postValue(quote!!)
        }

        isLoading.postValue(false)
    }
}