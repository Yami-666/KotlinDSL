import project_config.*

plugins {
    id("com.android.library")
    id("workplaces.sdk-version")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    accessors.`android-kotlin-base`
}

android {
    defaultConfig {
        buildConfigField(type = "String", name = "BASE_URL", value = "\"https://newsapi.org/\"")
        buildConfigField(type = "String", name = "API_KEY", value = "\"687c52bb86874e9696f8b76e0cc179f7\"")
    }
}

dependencies {
    implementation(project(":core"))

    room()
    hilt()
    moshi()
    common()
    dagger2()
    retrofit2()
}