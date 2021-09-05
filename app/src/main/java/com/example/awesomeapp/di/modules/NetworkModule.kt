package com.example.awesomeapp.di.modules

import com.example.awesomeapp.di.qualifier.NewsApiQualifier
import com.example.awesomeapp.di.scopes.AppScope
import com.example.data.remote.news.servies.NewsService
import dagger.Module
import dagger.Provides

@Module
object NetworkModule {
    @Provides
    @AppScope
    fun provideNewsService(@NewsApiQualifier apiKey: String): NewsService {
        return NewsService(apiKey)
    }
}
