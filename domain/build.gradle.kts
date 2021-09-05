import project_config.*

plugins {
    id ("com.android.library")
    id("workplaces.sdk-version")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    accessors.`android-kotlin-base`
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data"))

    ktx()
    hilt()
    common()
    dagger2()
    integrationTests()
}