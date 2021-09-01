import project_config.*

plugins {
    id("com.android.library")
    id("workplaces.sdk-version")
    kotlin("android")
    kotlin("kapt")
    accessors.`android-kotlin-base`
}


dependencies {
    implementation(project(":core"))

    room()
    moshi()
    common()
    dagger2()
    retrofit2()
}