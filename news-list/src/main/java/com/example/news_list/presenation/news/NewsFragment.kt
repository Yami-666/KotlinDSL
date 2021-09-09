package com.example.news_list.presenation.news

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fuckingapp.R
import com.example.fuckingapp.databinding.FragmentNewsBinding
import kotlinx.coroutines.flow.collect
import ru.nightgoat.kextensions.android.gone
import ru.nightgoat.kextensions.android.launchUITryCatch
import ru.nightgoat.kextensions.android.visible

class NewsFragment : BaseFragment(R.layout.fragment_news) {

    private val newsViewModel: NewsViewModel by viewModels()

    private val binding by viewBinding(FragmentNewsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel.apply {
            launchUITryCatch {
                news.collect {
                    binding.textView.text = it.toString()
                }
            }
            launchUITryCatch {
                isLoading.collect {
                    handleProgressBarState(it)
                }
            }
        }
    }

    private fun handleProgressBarState(isLoading: Boolean) {
        if (isLoading) {
            binding.loadingLayout.visible()
        } else {
            binding.loadingLayout.gone()
        }
    }
}