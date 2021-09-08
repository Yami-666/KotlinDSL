package com.example.news_list.application.di.modules.sources

import com.example.news_list.data.remote.INewsRemoteDataSource
import com.example.news_list.data.remote.NewsRemoteDataSource
import dagger.Binds
import dagger.Module

@Module
interface RemoteDataSourceModule {
    @Binds
    fun bindNewsRemoteDataSource(
        newsRemoteDataSource: NewsRemoteDataSource
    ): INewsRemoteDataSource
}