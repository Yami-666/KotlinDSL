package com.example.news_list.application.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news_list.application.di.MultiViewModelFactory
import com.example.news_list.application.di.annotations.ViewModelKey
import com.example.news_list.presenation.news.ExampleViewModel
import com.example.news_list.presenation.news.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @[IntoMap ViewModelKey(NewsViewModel::class)]
    fun bindNewsViewModel(newsViewModel: NewsViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(ExampleViewModel::class)]
    fun bindExampleViewModel(exampleViewModel: ExampleViewModel): ViewModel

    @Binds
    fun bindMultiViewModel(multiViewModel: MultiViewModelFactory): ViewModelProvider.Factory
}
