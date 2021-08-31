import project_config.core
import project_config.dagger2

plugins {
    id("com.android.library")
    id("workplaces.sdk-version")
    kotlin("android")
    kotlin("kapt")
    accessors.`android-kotlin-base`
}

dependencies {
    core()
    dagger2()
}