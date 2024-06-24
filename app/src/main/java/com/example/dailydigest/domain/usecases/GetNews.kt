package com.example.dailydigest.domain.usecases

import androidx.paging.PagingData
import com.example.dailydigest.domain.model.Article
import com.example.dailydigest.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }

}