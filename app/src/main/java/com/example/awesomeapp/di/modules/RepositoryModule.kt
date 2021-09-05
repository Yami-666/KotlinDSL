package com.example.awesomeapp.di.modules

import com.example.data.repository.news.INewsRepository
import com.example.data.repository.news.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindNewsRepository(newsRepository: NewsRepository): INewsRepository
}