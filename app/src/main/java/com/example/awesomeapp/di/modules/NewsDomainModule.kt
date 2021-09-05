package com.example.awesomeapp.di.modules

import com.example.domain.news.GetNewsUseCase
import com.example.domain.news.IGetNewsUseCase
import dagger.Binds
import dagger.Module

@Module
interface NewsDomainModule {
    @Binds
    fun bindNewsUseCase(getNewsUseCase: GetNewsUseCase): IGetNewsUseCase
}