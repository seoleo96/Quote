package com.example.quote.data

import com.example.quote.ui.home.QuoteUIModel

data class QuoteDataModel(
    private val _id: String,
    private val author: String,
    private val authorSlug: String,
    private val content: String,
    private val dateAdded: String,
    private val dateModified: String,
    private val length: Int,
    private val tags: List<String>,
) : QuoteDataToUiModelMapper {
    override fun map(mapper: QuoteDataMapper): QuoteUIModel {
        return mapper.map(author, content)
    }
}

interface QuoteDataToUiModelMapper {
    fun map(mapper: QuoteDataMapper): QuoteUIModel
}