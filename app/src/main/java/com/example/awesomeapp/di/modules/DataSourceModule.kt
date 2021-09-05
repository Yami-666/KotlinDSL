package com.example.awesomeapp.di.modules

import com.example.data.remote.news.NewsRemoteDataSource
import com.example.data.repository.news.INewsRemoteDataSource
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {
    @Binds
    fun bindNewsRemoteDataSource(newsRemoteDataSource: NewsRemoteDataSource): INewsRemoteDataSource
}