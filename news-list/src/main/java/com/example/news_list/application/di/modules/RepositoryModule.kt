package com.example.news_list.application.di.modules

import com.example.news_list.data.repository.INewsRepository
import com.example.news_list.data.repository.NewsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface RepositoryModule {
    @Binds
    @Singleton
    fun bindNewsRepository(newsRepository: NewsRepository): INewsRepository
}