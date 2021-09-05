package com.example.awesomeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.awesomeapp.features.NewsComponentViewModel
import com.example.awesomeapp.features.NewsViewModel
import dagger.Lazy
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var newsViewModelFactory: Lazy<NewsViewModel.Factory>

    private val newsViewModel: NewsViewModel by viewModels { newsViewModelFactory.get() }
    private val newsComponentViewModel: NewsComponentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsComponentViewModel.newsComponent.inject(this)

        setContent { MainContent(newsViewModel) }
    }
}


