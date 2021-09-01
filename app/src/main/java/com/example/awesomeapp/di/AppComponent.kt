package com.example.awesomeapp.di

import android.app.Application
import com.example.data.remote.servies.TestService
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope

@Component(modules = [AppModule::class])
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
class AppModule {
    @Provides
    @AppScope
    fun provideTestService(@ApiKeyQualifier apiKey: String): TestService {
        return TestService(apiKey)
    }
}

@Qualifier
annotation class ApiKeyQualifier

@Scope
annotation class AppScope