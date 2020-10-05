package com.padc.newsapp.data.vos

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)