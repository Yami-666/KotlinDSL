import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id("io.gitlab.arturbosch.detekt")
}

detekt {
    config = rootProject.files("detekt/config.yml")
    baseline = rootProject.file("detekt/baseline.xml")
    autoCorrect =  true
    parallel = true
    reports {
        xml {
            enabled = true
            destination = rootProject.file("build/reports/detekt.xml")
        }
    }
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "1.8"
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.18.0")
}

repositories {
    mavenCentral()
}