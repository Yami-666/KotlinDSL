import project_config.*

plugins {
    id("com.android.library")
    id("workplaces.sdk-version")
    kotlin("android")
    kotlin("kapt")
    accessors.`android-kotlin-base`
}

android {
    defaultConfig {
        buildConfigField(type = "String", name = "BASE_URL", value = "\"https://newsapi.org/\"")
    }
}

dependencies {
    implementation(project(":core"))

    room()
    moshi()
    common()
    dagger2()
    retrofit2()
}