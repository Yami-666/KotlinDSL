package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create

class RootProjectPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.extensions.create<WorkplacesExtensions>("workplaces")
    }
}

abstract class WorkplacesExtensions {
    abstract val minSdk: Property<Int>
    abstract val targetSdk: Property<Int>
    abstract val compileSdk: Property<Int>

    init {
        minSdk.convention(23)
            .finalizeValueOnRead()
        targetSdk.convention(31)
            .finalizeValueOnRead()
        compileSdk.convention(31)
            .finalizeValueOnRead()
    }
}