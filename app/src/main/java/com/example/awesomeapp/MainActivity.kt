package com.example.awesomeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomeapp.features.NewsComponentViewModel
import com.example.awesomeapp.features.NewsViewModel
import com.example.awesomeapp.features.TestScreen
import com.example.awesomeapp.ui.theme.FuckingAppTheme
import dagger.Lazy
import javax.inject.Inject


class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var newsViewModelFactory: Lazy<NewsViewModel.Factory>

    private val newsComponentViewModel: NewsComponentViewModel by viewModels()
    private val newsViewModel: NewsViewModel by viewModels { newsViewModelFactory.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsComponentViewModel.newsComponent.inject(this)

        setContent {
            FuckingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TestScreen().TestScreen(newsViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FuckingAppTheme {
        Greeting("Android")
    }
}