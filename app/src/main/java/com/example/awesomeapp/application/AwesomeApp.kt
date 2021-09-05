package com.example.awesomeapp.application

import android.app.Application
import com.example.awesomeapp.di.component.AppComponent
import com.example.awesomeapp.di.component.DaggerAppComponent
import com.example.awesomeapp.di.component.NewsDependency
import com.example.awesomeapp.di.component.NewsDependencyProvider
import com.example.fuckingapp.BuildConfig

class AwesomeApp : Application(), NewsDependencyProvider {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .apiKey(BuildConfig.API_KEY)
            .build()
    }
    override val newsDependency: NewsDependency
        get() = appComponent
}