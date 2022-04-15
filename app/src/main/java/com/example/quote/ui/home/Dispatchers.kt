package com.example.quote.ui.home

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

interface Dispatchers {

    fun launchUI(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job
    fun launchBackground(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job

    class Base : Dispatchers {
        override fun launchUI(
            scope: CoroutineScope,
            block: suspend CoroutineScope.() -> Unit,
        ) = scope.launch(kotlinx.coroutines.Dispatchers.Main, block = block)

        override fun launchBackground(
            scope: CoroutineScope,
            block: suspend CoroutineScope.() -> Unit,
        ) = scope.launch(kotlinx.coroutines.Dispatchers.IO, block = block)
    }
}