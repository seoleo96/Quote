package com.example.quote.data

interface QuoteRepository {

    suspend fun fetchQuote(): QuoteData

    class Base(
        private val quoteCloudDataSource: QuoteCloudDataSource,
    ) : QuoteRepository {
        override suspend fun fetchQuote() = try {
            val data: QuoteDataModel = quoteCloudDataSource.fetchQuote()
            QuoteData.Success(data)
        } catch (e: Exception) {
            QuoteData.Fail(e)
        }
    }
}