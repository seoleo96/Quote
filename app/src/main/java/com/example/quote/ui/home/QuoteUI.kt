package com.example.quote.ui.home

import com.example.quote.data.ErrorType

sealed class QuoteUI {
    class Success(val quoteUIModel: String) : QuoteUI()
    class Fail(val e: ErrorType) : QuoteUI()
}
