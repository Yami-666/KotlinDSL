import project_config.*
import project_config.Dependencies.APP_ID
import project_config.Dependencies.test_instrumentation_runner

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
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

        buildConfigField(type = "String", name = "API_KEY", value = "\"687c52bb86874e9696f8b76e0cc179f7\"")
    }

    buildFeatures {
        compose = true
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
    common()
    compose()
    dagger2()
    retrofit2()
    lifecycle()
    navigation()
    integrationTests()
}