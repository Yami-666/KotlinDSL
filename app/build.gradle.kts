import project_config.*
import project_config.Dependencies.APP_ID
import project_config.Dependencies.test_instrumentation_runner

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("workplaces.sdk-version")
    accessors.`android-kotlin-base`
}

android {
    defaultConfig {
        applicationId = APP_ID

        testInstrumentationRunner = test_instrumentation_runner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        compose = true
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

    implementation(Dependencies.coil)
    implementation(Dependencies.app_compat)
    implementation(Dependencies.android_material)
    implementation(Dependencies.constraint_layout)

    ktx()
    hilt()
    common()
    compose()
    dagger2()
    retrofit2()
    lifecycle()
    navigation()
    integrationTests()
}