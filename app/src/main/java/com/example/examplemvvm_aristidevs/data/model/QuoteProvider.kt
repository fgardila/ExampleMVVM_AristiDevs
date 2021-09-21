package com.example.examplemvvm_aristidevs.data.model

import com.example.examplemvvm_aristidevs.domain.model.QuoteModel

class QuoteProvider {
    companion object {
        var quotes: List<QuoteModel> = emptyList()
    }
}