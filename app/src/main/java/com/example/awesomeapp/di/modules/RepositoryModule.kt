package com.example.awesomeapp.di.modules

import com.example.data.repository.news.INewsRepository
import com.example.data.repository.news.NewsRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun bindNewsRepository(newsRepository: NewsRepository): INewsRepository
}