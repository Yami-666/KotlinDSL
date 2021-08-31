package plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class SdkVersionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configureSdk()
    }

    private fun Project.configureSdk() = configure<BaseExtension> {
        val config = extensions.getByType<WorkplacesExtensions>()
        defaultConfig {
            minSdk = config.minSdk.get()
            targetSdk = config.targetSdk.get()
            compileSdkVersion(config.compileSdk.get())
        }
    }
}