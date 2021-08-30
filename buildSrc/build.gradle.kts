plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.18.0")
    implementation("com.android.tools.build:gradle:7.0.1")
}