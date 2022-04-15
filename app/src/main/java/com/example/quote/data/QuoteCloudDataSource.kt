package com.example.quote.data

interface QuoteCloudDataSource {

    suspend fun fetchQuote(): QuoteDataModel

    class Base(private val quoteService: QuoteService) : QuoteCloudDataSource {
        override suspend fun fetchQuote(): QuoteDataModel {
            return quoteService.fetchQuote()
        }
    }
}