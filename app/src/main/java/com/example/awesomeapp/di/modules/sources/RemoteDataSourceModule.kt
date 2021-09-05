package com.example.awesomeapp.di.modules.sources

import com.example.data.remote.news.NewsRemoteDataSource
import com.example.data.repository.news.INewsRemoteDataSource
import dagger.Binds
import dagger.Module

@Module
interface RemoteDataSourceModule {
    @Binds
    fun bindNewsRemoteDataSource(
        newsRemoteDataSource: NewsRemoteDataSource
    ): INewsRemoteDataSource
}