package com.example.dailydigest.di

import android.app.Application
import androidx.room.Room
import com.example.dailydigest.data.local.NewsDao
import com.example.dailydigest.data.local.NewsDatabase
import com.example.dailydigest.data.local.NewsTypeConverter
import com.example.dailydigest.data.remote.NewsApi
import com.example.dailydigest.data.repository.NewsRepositoryImpl
import com.example.dailydigest.domain.repository.NewsRepository
import com.example.dailydigest.domain.usecases.DeleteArticle
import com.example.dailydigest.domain.usecases.GetArticle
import com.example.dailydigest.domain.usecases.GetArticles
import com.example.dailydigest.domain.usecases.GetNews
import com.example.dailydigest.domain.usecases.NewsUseCases
import com.example.dailydigest.domain.usecases.SearchNews
import com.example.dailydigest.domain.usecases.UpsertArticle
import com.example.dailydigest.util.Constants.BASE_URL
import com.example.dailydigest.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)

    @Provides
    @Singleton
    fun providesNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            getArticles = GetArticles(newsRepository),
            getArticle = GetArticle(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun providesNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}