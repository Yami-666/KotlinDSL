package com.example.awesomeapp.features

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.awesomeapp.di.component.DaggerNewsComponent
import com.example.awesomeapp.di.component.NewsComponent
import com.example.awesomeapp.di.component.newsDependencyProvider

class NewsComponentViewModel(application: Application) : AndroidViewModel(application){
    val newsComponent: NewsComponent by lazy {
        DaggerNewsComponent.builder()
            .dependency(application.newsDependencyProvider.newsDependency)
            .build()
    }
}