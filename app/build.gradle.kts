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
        applicationId = "com.example.awesomeapp"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    ktx()
    core()
    compose()
    dagger2()
    integrationTests()
    implementation(Dependencies.app_compat)
    implementation(Dependencies.android_material)
}