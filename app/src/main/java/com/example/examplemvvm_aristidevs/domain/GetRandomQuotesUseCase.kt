package com.example.examplemvvm_aristidevs.domain

import com.example.examplemvvm_aristidevs.data.model.QuoteProvider
import com.example.examplemvvm_aristidevs.domain.model.QuoteModel

class GetRandomQuotesUseCase {

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}