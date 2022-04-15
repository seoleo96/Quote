package com.example.quote.data

import retrofit2.http.GET

interface QuoteService {

    @GET("random")
    suspend fun fetchQuote(): QuoteDataModel
}