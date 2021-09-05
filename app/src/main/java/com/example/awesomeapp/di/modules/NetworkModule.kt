package com.example.awesomeapp.di.modules

import com.example.data.remote.news.servies.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideNewsService(): NewsService {
        return NewsService()
    }
}
