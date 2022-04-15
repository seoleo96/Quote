package com.example.quote.data

import com.example.quote.ui.home.QuoteUIModel

interface QuoteDataMapper {

    fun map(quoteDataModel: String, content: String): QuoteUIModel

    class Base : QuoteDataMapper {
        override fun map(quoteDataModel: String, content: String): QuoteUIModel {
            return QuoteUIModel(quoteDataModel, content)
        }
    }
}