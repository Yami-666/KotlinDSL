import project_config.common
import project_config.dagger2

plugins {
    id("com.android.library")
    id("workplaces.sdk-version")
    kotlin("android")
    kotlin("kapt")
    accessors.`android-kotlin-base`
}


dependencies {
    implementation(project(":core"))

    common()
    dagger2()
}