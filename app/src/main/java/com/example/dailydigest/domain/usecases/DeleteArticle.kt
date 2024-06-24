package com.example.dailydigest.domain.usecases

import com.example.dailydigest.domain.model.Article
import com.example.dailydigest.domain.repository.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article)
    }

}