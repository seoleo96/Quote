package com.example.quote.data

import com.example.quote.base.Mapper
import com.example.quote.ui.home.QuoteUI
import retrofit2.HttpException
import java.net.UnknownHostException

sealed class QuoteData : Mapper<QuoteUI, QuoteDataToUiMapper> {

    data class Success(private val quoteDataModel: QuoteDataModel) : QuoteData() {
        override fun map(mapper: QuoteDataToUiMapper): QuoteUI {
            return mapper.map(quoteDataModel)
        }
    }

    data class Fail(private val exception: Exception) : QuoteData() {
        override fun map(mapper: QuoteDataToUiMapper): QuoteUI {
            return mapper.map(
                when (exception) {
                    is UnknownHostException -> ErrorType.NO_CONNECTION
                    is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                    else -> ErrorType.GENERIC_ERROR
                }
            )
        }

    }
}
