import project_config.common
import project_config.dagger2
import project_config.integrationTests
import project_config.ktx

plugins {
    id ("com.android.library")
    id("workplaces.sdk-version")
    kotlin("android")
    kotlin("kapt")
    accessors.`android-kotlin-base`
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data"))

    ktx()
    common()
    dagger2()
    integrationTests()
}