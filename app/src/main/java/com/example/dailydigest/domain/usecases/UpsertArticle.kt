package com.example.dailydigest.domain.usecases

import com.example.dailydigest.domain.model.Article
import com.example.dailydigest.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article) {
        newsRepository.upsertArticle(article)
    }

}