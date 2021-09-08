buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(project_config.Dependencies.gradle_tools_plugin)
        classpath(project_config.Dependencies.kotlin_gradle_plugin)
        classpath(project_config.Dependencies.navigation_safe_args)
        classpath(project_config.Dependencies.hilt_plugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
    }
}

allprojects {
    apply(plugin = "workplaces.root-project")
    apply(plugin = "accessors.detekt-convention")

    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
