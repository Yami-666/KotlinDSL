package project_config

object Dependencies {
    // Room
    const val room_runtime = "androidx.room:room-runtime:${Versions.ROOM}"
    const val room_processor = "androidx.room:room-runtime:${Versions.ROOM}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.ROOM}"
    const val room_testing = "androidx.room:room-testing:${Versions.ROOM}"
    const val room_paging3 = "androidx.room:room-paging:${Versions.ROOM_PAGING3}"

    // Retrofit 2
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.MOSHI_CONVERTER}"

    // Coil
    const val coil = "io.coil-kt:coil:${Versions.COIL}"

    // Moshi
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val moshi_codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.MOSHI}"

    // Compose
    const val compose_ui = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val compose_app_compat = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val compose_tool_preview = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val compose_junit_test = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
    const val compose_ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val compose_activity = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"

    // Dagger 2
    const val dagger = "com.google.dagger:dagger:${Versions.DAGGER2}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.DAGGER2}"
    const val dagger_android = "com.google.dagger:dagger-android-support:${Versions.DAGGER2}"
    const val dagger_android_processor = "com.google.dagger:dagger-android-processor:${Versions.DAGGER2}"

    // Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.DAGGER2}"
    const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.DAGGER2}"

    // ktx
    const val lifecycle_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_KTX}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val activity_ktx = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.ROOM_KTX}"
    const val work_manager_ktx = "androidx.work:work-runtime-ktx:${Versions.WORK_MANAGER_KTX}"
    const val play_market_ktx = "com.google.android.play:core-ktx:${Versions.PLAY_MARKET_KTX}"
    const val palette_ktx = "androidx.palette:palette-ktx:${Versions.PALETTE_KTX}"


    // navigation component
    const val navigation_runtime_ktx = "androidx.navigation:navigation-runtime-ktx:${Versions.NAVIGATION}"
    const val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val navigation_testing = "androidx.navigation:navigation-testing:${Versions.NAVIGATION}"
    const val navigation_compose = "androidx.navigation:navigation-compose:${Versions.NAVIGATION_COMPOSE}"
    const val navigation_safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}"

    // lifecycle
    const val lifecycle_view_model = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val lifecycle_saved_state = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.LIFECYCLE}"
    const val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE}"
    const val lifecycle_service = "androidx.lifecycle:lifecycle-service:${Versions.LIFECYCLE}"

    // app config
    const val gradle_tools_plugin = "com.android.tools.build:gradle:${Versions.GRADLE}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val std_lib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"

    // Other
    const val app_compat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val android_material = "com.google.android.material:material:${Versions.MATERIAL}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val junit_test = "junit:junit:${Versions.JUNIT}"
    const val junit_android_ext = "androidx.test.ext:junit:${Versions.JUNIT_ANDROID}"
    const val espresso_ui_test = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val kextensions = "com.github.nightgoat:kextensions:${Versions.KEX}"
    const val timber = "com.jakewharton.timber:timber:${Versions.TIMBER}"


    const val test_instrumentation_runner = "androidx.test.runner.AndroidJUnitRunner"
    const val APP_ID = "com.example.awesomeapp"
}