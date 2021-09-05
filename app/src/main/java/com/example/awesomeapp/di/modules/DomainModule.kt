package com.example.awesomeapp.di.modules

import com.example.domain.news.GetNewsUseCase
import com.example.domain.news.IGetNewsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {
    @Binds
    fun bindNewsUseCase(getNewsUseCase: GetNewsUseCase): IGetNewsUseCase
}