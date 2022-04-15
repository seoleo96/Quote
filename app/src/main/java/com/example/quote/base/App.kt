package com.example.quote.base

import android.app.Application
import com.example.quote.data.QuoteCloudDataSource
import com.example.quote.data.QuoteDataMapper
import com.example.quote.data.QuoteRepository
import com.example.quote.data.QuoteService
import com.example.quote.ui.home.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    lateinit var viewModel: HomeViewModel

    companion object {

        private val BASE_URL = "https://api.quotable.io/"

        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        private val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.apply {
                addInterceptor(interceptor)
            }
        }.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        val quoteService = retrofit.create(QuoteService::class.java)
        val quoteCloudDataSource = QuoteCloudDataSource.Base(quoteService)
        viewModel = HomeViewModel(
            QuoteRepository.Base(quoteCloudDataSource),
            SuccessCommunication.Base(),
            ProgressCommunication.Base(),
            ErrorCommunication.Base(),
            com.example.quote.ui.home.Dispatchers.Base(),
            BaseQuoteDataToUiMapper(QuoteDataMapper.Base(), QuoteUiContent.Base())
        )
    }
}