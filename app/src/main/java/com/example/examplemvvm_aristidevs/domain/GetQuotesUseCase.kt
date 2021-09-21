package com.example.examplemvvm_aristidevs.domain

import com.example.examplemvvm_aristidevs.data.QuoteRepository
import com.example.examplemvvm_aristidevs.domain.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}