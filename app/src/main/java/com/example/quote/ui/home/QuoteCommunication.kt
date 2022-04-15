package com.example.quote.ui.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

interface QuoteCommunication<T> : Observable<T>, Mapper<T> {

    abstract class Base<T> : QuoteCommunication<T>{

        private val liveData = MutableLiveData<T>()

        override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
            liveData.observe(lifecycleOwner, observer)
        }

        override fun map(data: T) {
            liveData.value = data!!
        }
    }
}

interface Observable<T> {

    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<T>)
}

interface Mapper<T> {

    fun map(data: T)
}