package accessors

import com.android.build.gradle.BaseExtension
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

android {
    defaultConfig {
        val proguardFiles = rootProject.fileTree("proguard").files +
                getDefaultProguardFile("proguard-android-optimize.txt")
        proguardFiles(*proguardFiles.toTypedArray())
    }

    signingConfigs {
        create("release") {
            keyAlias = "MyKeyAlias"
            keyPassword = "MyKeyPassword"
            storeFile = file("Path/To/Key")
            storePassword = "KeyStorePassword"
        }
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
        }
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    sourceSets.forEach { it.java.srcDir("src/${it.name}/kotlin") }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

fun Project.android(configure: BaseExtension.() -> Unit) {
    extensions.configure("android", configure)
}
