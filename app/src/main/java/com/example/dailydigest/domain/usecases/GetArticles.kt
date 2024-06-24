package com.example.dailydigest.domain.usecases

import com.example.dailydigest.domain.model.Article
import com.example.dailydigest.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.getArticles()
    }

}