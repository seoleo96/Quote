package com.example.quote.ui.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface AllObservables {
    fun successObserve(lifecycleOwner: LifecycleOwner, observer: Observer<String>)
    fun progressObserve(lifecycleOwner: LifecycleOwner, observer: Observer<Boolean>)
    fun errorObserve(lifecycleOwner: LifecycleOwner, observer: Observer<String>)
}