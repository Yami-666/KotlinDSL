package com.example.news_list.application

import android.app.Application
import com.example.news_list.application.di.component.AppComponent
import com.example.news_list.application.di.component.DaggerAppComponent

class AwesomeApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}