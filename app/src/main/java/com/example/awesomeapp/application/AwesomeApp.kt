package com.example.awesomeapp.application

import android.app.Application
import com.example.awesomeapp.di.AppComponent
import com.example.awesomeapp.di.DaggerAppComponent
import com.example.fuckingapp.BuildConfig

class AwesomeApp : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .apiKey(BuildConfig.API_KEY)
            .build()
    }
}