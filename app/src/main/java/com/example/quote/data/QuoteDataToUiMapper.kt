package com.example.quote.data

import com.example.quote.ui.home.QuoteUI

interface QuoteDataToUiMapper {
    fun map(quoteDataModel: QuoteDataModel): QuoteUI
    fun map(e: ErrorType): QuoteUI
}