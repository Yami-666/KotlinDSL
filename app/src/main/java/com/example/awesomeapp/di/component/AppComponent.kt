package com.example.awesomeapp.di.component

import com.example.awesomeapp.di.modules.DomainModule
import com.example.awesomeapp.di.modules.NetworkModule
import com.example.awesomeapp.di.modules.RepositoryModule
import com.example.awesomeapp.di.modules.sources.LocalDataSourceModule
import com.example.awesomeapp.di.modules.sources.RemoteDataSourceModule
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        RemoteDataSourceModule::class,
        LocalDataSourceModule::class,
        RepositoryModule::class,
        DomainModule::class,
    ]
)
interface AppComponent
