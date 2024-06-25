package com.example.dailydigest.presentation.bookmark

import com.example.dailydigest.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)