package com.example.dailydigest.data.remote

import com.example.dailydigest.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)