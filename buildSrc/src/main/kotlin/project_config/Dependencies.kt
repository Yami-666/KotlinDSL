package project_config

object Dependencies {
    // Compose
    const val compose_ui = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val compose_app_compat = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val compose_tool_preview = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val compose_junit_test = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
    const val compose_ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val compose_activity = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"

    const val core_ktx = "androidx.core:core-ktx:${Versions.KTX}"
    const val app_compat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val android_material = "com.google.android.material:material:${Versions.MATERIAL}"
    const val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val junit_test = "junit:junit:${Versions.JUNIT}"
    const val junit_android_ext = "androidx.test.ext:junit:${Versions.JUNIT_ANDROID}"
    const val espresso_ui_test = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"

    // Dagger 2
    const val dagger = "com.google.dagger:dagger:${Versions.DAGGER2}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.DAGGER2}"
    const val dagger_android = "com.google.dagger:dagger-android-support:${Versions.DAGGER2}"
    const val dagger_android_processor =
        "com.google.dagger:dagger-android-processor:${Versions.DAGGER2}"

    // ktx
    const val lifecycle_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_KTX}"

    // app config
    const val test_instrumentation_runner = "androidx.test.runner.AndroidJUnitRunner"
    const val std_lib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    const val APP_ID = "com.example.multimoduleapp"
}