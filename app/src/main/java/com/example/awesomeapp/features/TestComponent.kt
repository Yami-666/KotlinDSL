package com.example.awesomeapp.features

import com.example.data.remote.servies.TestService
import dagger.Component
import dagger.Module
import javax.inject.Scope


@TestScope
@Component(dependencies = [TestDeps::class])
interface TestComponent {}

@Module
internal class TestModule {}

interface TestDeps {
    val testService: TestService
}

@Scope
annotation class TestScope