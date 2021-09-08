package com.example.news_list.application.di.modules

import com.example.news_list.data.remote.servies.NewsService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideNewsService(): NewsService {
        return NewsService()
    }
}
