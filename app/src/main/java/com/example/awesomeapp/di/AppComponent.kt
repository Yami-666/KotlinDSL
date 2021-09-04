package com.example.awesomeapp.di

import android.app.Application
import com.example.data.remote.news.servies.NewsService
import com.example.data.repository.news.INewsRemoteDataSource
import com.example.domain.news.IGetNewsUseCase
import com.example.data.repository.news.INewsRepository
import com.example.fuckingapp.BuildConfig.BASE_URL
import dagger.*
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Qualifier
import javax.inject.Scope

@Component(modules = [
    NetworkModule::class,
    DataSourceBindModule::class,
    RepositoryBindModule::class,
    DomainBindModule::class,
    ViewModelModule::class
])
@AppScope
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun apiKey(@ApiKeyQualifier apiKey: String): Builder

        fun build(): AppComponent
    }
}

@Module
interface NetworkModule {
    @Provides
    @AppScope
    fun provideNewsService(@ApiKeyQualifier apiKey: String): NewsService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create()
    }
}

interface DataSourceBindModule {
    @Binds
    fun bindNewsRemoteDataSourceToApiService(
        newsApi: NewsService
    ): INewsRemoteDataSource
}

interface RepositoryBindModule {
    @Binds
    fun bindNewsRepositoryToDataSource(
        remoteDataSource: INewsRemoteDataSource
    ): INewsRepository
}

interface DomainBindModule {
    @Binds
    fun bindNewsUseCaseToNewsRepository(
        newsRepository: INewsRepository
    ): IGetNewsUseCase
}

interface ViewModelModule

@Qualifier
annotation class ApiKeyQualifier

@Scope
annotation class AppScope