
import project_config.*

plugins {
    id("com.android.application")
    id("workplaces.sdk-version")
    kotlin("android")
    kotlin("kapt")
    accessors.`android-kotlin-base`
}

android {
    defaultConfig {
        buildConfigField(type = "String", name = "API_KEY", value = "\"687c52bb86874e9696f8b76e0cc179f7\"")
        buildConfigField(type = "String", name = "BASE_URL", value = "\"https://newsapi.org/\"")
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core"))

    implementation(Dependencies.coil)
    implementation(Dependencies.app_compat)
    implementation(Dependencies.android_material)
    implementation(Dependencies.constraint_layout)
    implementation(Dependencies.fragment)
    implementation(Dependencies.view_binding_delegate)

    ktx()
    common()
    dagger2()
    retrofit2()
    moshi()
    lifecycle()
    navigation()
    integrationTests()
}