package com.example.awesomeapp.di.component

import android.app.Application
import android.content.Context
import com.example.awesomeapp.MainActivity
import com.example.awesomeapp.di.scopes.NewsScope
import com.example.domain.news.IGetNewsUseCase
import dagger.Component
import dagger.Module

@Component(
    dependencies = [NewsDependency::class],
    modules = [NewsModule::class]
)
@NewsScope
interface NewsComponent {
    @Component.Builder
    interface Builder {

        fun dependency(it: NewsDependency): Builder

        fun build(): NewsComponent
    }

    fun inject(activity: MainActivity)
}

@Module
class NewsModule {

}

interface NewsDependencyProvider {
    val newsDependency: NewsDependency
}

interface NewsDependency {
    val getNewsUseCase: IGetNewsUseCase
}

val Context.newsDependencyProvider: NewsDependencyProvider
    get() = when(this) {
        is NewsDependencyProvider -> this
        is Application -> error("Application must implements NewsDependencyProvider")
        else -> applicationContext.newsDependencyProvider
    }