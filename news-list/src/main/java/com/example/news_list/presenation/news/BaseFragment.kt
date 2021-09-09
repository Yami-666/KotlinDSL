package com.example.news_list.presenation.news

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.news_list.application.di.component.appComponent
import javax.inject.Inject

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)

        context.appComponent.apply {
            inject(newsFragment = this@BaseFragment)
            viewModelFactory = factory
        }
    }
}

inline fun <reified VM : ViewModel> BaseFragment.viewModels(): Lazy<VM> {
    return this.viewModels(factoryProducer = ::viewModelFactory)
}

