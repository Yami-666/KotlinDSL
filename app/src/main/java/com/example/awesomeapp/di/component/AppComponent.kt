package com.example.awesomeapp.di.component

import android.app.Application
import com.example.awesomeapp.di.NewsApiQualifier
import com.example.awesomeapp.di.modules.DataSourceModule
import com.example.awesomeapp.di.modules.NetworkModule
import com.example.awesomeapp.di.modules.NewsDomainModule
import com.example.awesomeapp.di.modules.RepositoryModule
import com.example.awesomeapp.di.scopes.AppScope
import com.example.awesomeapp.features.NewsViewModel
import com.example.domain.news.IGetNewsUseCase
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        DataSourceModule::class,
        RepositoryModule::class,
        NewsDomainModule::class,
    ]
)
@AppScope
interface AppComponent : NewsDependency {

    override val getNewsUseCase: IGetNewsUseCase

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun apiKey(@NewsApiQualifier apiKey: String): Builder

        fun build(): AppComponent
    }

    fun inject(it: NewsViewModel)
}
