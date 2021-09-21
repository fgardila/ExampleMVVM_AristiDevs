package com.example.examplemvvm_aristidevs.data

import com.example.examplemvvm_aristidevs.data.network.QuoteService
import com.example.examplemvvm_aristidevs.domain.model.QuoteModel
import com.example.examplemvvm_aristidevs.data.model.QuoteProvider

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}