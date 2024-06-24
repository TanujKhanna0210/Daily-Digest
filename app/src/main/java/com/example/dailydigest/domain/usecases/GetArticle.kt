package com.example.dailydigest.domain.usecases

import com.example.dailydigest.domain.model.Article
import com.example.dailydigest.domain.repository.NewsRepository

class GetArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url:String): Article? {
        return newsRepository.getArticle(url)
    }

}