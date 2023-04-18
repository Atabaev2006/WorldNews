package com.example.worldnews.model.news

data class Everything(
    val articles: ArrayList<ArticleX>,
    val status: String,
    val totalResults: Int
)