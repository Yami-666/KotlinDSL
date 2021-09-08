package com.example.news_list.application.di.modules

import com.example.news_list.domain.GetNewsUseCase
import com.example.news_list.domain.IGetNewsUseCase
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindNewsUseCase(getNewsUseCase: GetNewsUseCase): IGetNewsUseCase
}