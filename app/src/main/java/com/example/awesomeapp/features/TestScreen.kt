package com.example.awesomeapp.features

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.extensions.logg
import com.example.data.repository.news.data.NewsData

class TestScreen : ComponentActivity() {
    @Preview
    @Composable
    fun TestScreen(newsViewModel: NewsViewModel = viewModel()) {
        val news = newsViewModel.news.collectAsState(initial = emptyList<NewsData>())
        logg {
            news.value.toString()
        }
    }
}