package com.example.news_list.application.di.component

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.news_list.application.AwesomeApp
import com.example.news_list.application.di.MultiViewModelFactory
import com.example.news_list.application.di.modules.DomainModule
import com.example.news_list.application.di.modules.NetworkModule
import com.example.news_list.application.di.modules.RepositoryModule
import com.example.news_list.application.di.modules.ViewModelModule
import com.example.news_list.application.di.modules.sources.LocalDataSourceModule
import com.example.news_list.application.di.modules.sources.RemoteDataSourceModule
import dagger.Component
import javax.inject.Singleton


@[Component (
    modules = [
        NetworkModule::class,
        RemoteDataSourceModule::class,
        LocalDataSourceModule::class,
        RepositoryModule::class,
        DomainModule::class,
        ViewModelModule::class,
    ]
) Singleton]
interface AppComponent {
    fun inject(newsFragment: Fragment)

    val factory: MultiViewModelFactory
}

val Context.appComponent: AppComponent
    get() = when(this) {
        is AwesomeApp -> appComponent
        else -> this.applicationContext.appComponent
    }



