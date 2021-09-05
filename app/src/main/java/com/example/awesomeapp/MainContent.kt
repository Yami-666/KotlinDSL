package com.example.awesomeapp

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.awesomeapp.features.NewsScreen
import com.example.awesomeapp.features.NewsViewModel
import com.example.awesomeapp.ui.theme.AwesomeAppTheme

@Composable
internal fun MainContent(newsViewModel: NewsViewModel) {
    val newsScreen = NewsScreen()

    AwesomeAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            newsScreen.ArticlesDescription(newsViewModel)
        }
    }
}