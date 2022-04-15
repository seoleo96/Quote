package com.example.quote.ui.home

data class QuoteUIModel(
    private val author: String,
    private val content: String,
) : QuoteUiModelToString {
    override fun map(mapper: QuoteUiContent): String {
        return mapper.map(author, content)
    }
}

interface QuoteUiModelToString {
    fun map(mapper: QuoteUiContent): String
}

interface QuoteUiContent {

    fun map(author: String, content: String): String

    class Base : QuoteUiContent {
        override fun map(author: String, content: String): String {
            return "$content \n\n $author"
        }
    }
}
