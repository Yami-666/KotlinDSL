import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.5.21"
}

repositories {
    mavenCentral()
    google()
}

gradlePlugin {
    plugins {
        create("root-project") {
            id = "workplaces.root-project"
            implementationClass = "plugins.RootProjectPlugin"
        }
    }
    plugins {
        create("sdk-version") {
            id = "workplaces.sdk-version"
            implementationClass = "plugins.SdkVersionPlugin"
        }
    }
}

dependencies {
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.18.0")
    implementation("com.android.tools.build:gradle:7.0.2")
    implementation(kotlin("gradle-plugin", version = "1.5.21"))
    implementation(kotlin("stdlib-jdk8"))
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}