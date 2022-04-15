package com.example.quote.base

interface Mapper<T, R> {

    fun map(mapper: R) : T
}