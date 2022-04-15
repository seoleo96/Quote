package com.example.quote.ui.home

import com.example.quote.data.ErrorType
import com.example.quote.data.QuoteDataMapper
import com.example.quote.data.QuoteDataModel
import com.example.quote.data.QuoteDataToUiMapper

class BaseQuoteDataToUiMapper(
    private val quoteDataMapper: QuoteDataMapper,
    private val quoteUiContent: QuoteUiContent,
) : QuoteDataToUiMapper {

    override fun map(quoteDataModel: QuoteDataModel): QuoteUI {
        val data: String = quoteDataModel
            .map(quoteDataMapper)
            .map(quoteUiContent)
        return QuoteUI.Success(data)
    }

    override fun map(e: ErrorType): QuoteUI {
        return QuoteUI.Fail(e)
    }
}