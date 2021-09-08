package com.example.news_list.presenation.news

import androidx.lifecycle.ViewModel
import com.example.news_list.domain.GetNewsUseCase
import javax.inject.Inject

class ExampleViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
): ViewModel()