import project_config.common
import project_config.dagger2
import project_config.hilt

plugins {
    id("com.android.library")
    id("workplaces.sdk-version")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    accessors.`android-kotlin-base`
}


dependencies {
    implementation(project(":core"))

    hilt()
    common()
    dagger2()
}