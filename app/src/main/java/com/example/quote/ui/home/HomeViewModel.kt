package com.example.quote.ui.home

import androidx.lifecycle.*
import com.example.quote.data.ErrorType
import com.example.quote.data.QuoteData
import com.example.quote.data.QuoteDataToUiMapper
import com.example.quote.data.QuoteRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val quoteRepository: QuoteRepository,
    private val successCommunication: SuccessCommunication,
    private val progressCommunication: ProgressCommunication,
    private val errorCommunication: ErrorCommunication,
    private val dispatchers: Dispatchers,
    private val quoteDataToUiMapper: QuoteDataToUiMapper
) : ViewModel(), AllObservables {

    override fun successObserve(lifecycleOwner: LifecycleOwner, observer: Observer<String>) {
        successCommunication.observe(lifecycleOwner, observer)
    }

    override fun errorObserve(lifecycleOwner: LifecycleOwner, observer: Observer<String>) {
        errorCommunication.observe(lifecycleOwner, observer)
    }

    override fun progressObserve(lifecycleOwner: LifecycleOwner, observer: Observer<Boolean>) {
        progressCommunication.observe(lifecycleOwner, observer)
    }

    fun fetchQuotes(){
        progressCommunication.map(true)
        dispatchers.launchBackground(viewModelScope){
            val quote: QuoteData = quoteRepository.fetchQuote()
            dispatchers.launchUI(viewModelScope){
                progressCommunication.map(false)
                when(val data = quote.map(quoteDataToUiMapper)){
                    is QuoteUI.Success -> successCommunication.map(data.quoteUIModel)
                    is QuoteUI.Fail -> errorCommunication.map(data.e.toString())
                }
            }
        }
    }
}