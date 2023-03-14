package com.example.worldnews.model.news

data class New(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)