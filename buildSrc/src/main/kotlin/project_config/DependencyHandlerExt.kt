package project_config

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.dagger2() {
    compileOnly(Dependencies.dagger)
    implementation(Dependencies.dagger_android)
    kapt(Dependencies.dagger_compiler)
    kapt(Dependencies.dagger_android_processor)
}

fun DependencyHandler.common() {
    implementation(Dependencies.std_lib)
    implementation(Dependencies.core_ktx)
    // For flow implementation
    implementation(Dependencies.lifecycle_ktx)
    implementation(Dependencies.kextensions)
    implementation(Dependencies.timber)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.compose_ui)
    implementation(Dependencies.compose_app_compat)
    implementation(Dependencies.compose_tool_preview)
    implementation(Dependencies.compose_activity)
    androidTestImplementation(Dependencies.compose_junit_test)
    debugImplementation(Dependencies.compose_ui_tooling)
}

fun DependencyHandler.integrationTests() {
    testImplementation(Dependencies.junit_test)
    androidTestImplementation(Dependencies.junit_android_ext)
    androidTestImplementation(Dependencies.espresso_ui_test)
}

fun DependencyHandler.moshi() {
    implementation(Dependencies.moshi)
    kapt(Dependencies.moshi_codegen)
}

fun DependencyHandler.ktx() {
    implementation(Dependencies.lifecycle_ktx)
    implementation(Dependencies.activity_ktx)
    implementation(Dependencies.fragment_ktx)
    implementation(Dependencies.room_ktx)
}

fun DependencyHandler.lifecycle() {
    implementation(Dependencies.lifecycle_view_model)
    implementation(Dependencies.lifecycle_saved_state)
    kapt(Dependencies.lifecycle_compiler)
    implementation(Dependencies.lifecycle_service)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.navigation_runtime_ktx)
    implementation(Dependencies.navigation_fragment_ktx)
    implementation(Dependencies.navigation_ui_ktx)
    androidTestImplementation(Dependencies.navigation_testing)
    implementation(Dependencies.navigation_compose)
//    implementation(Dependencies.navigation_safe_args)
}

fun DependencyHandler.retrofit2() {
    implementation(Dependencies.retrofit2)
    implementation(Dependencies.moshi_converter)
}

fun DependencyHandler.room() {
    implementation(Dependencies.room_paging3)
    annotationProcessor(Dependencies.room_processor)
    kapt(Dependencies.room_runtime)
    kapt(Dependencies.room_compiler)
    testImplementation(Dependencies.room_testing)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

private fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}

private fun DependencyHandler.annotationProcessor(depName: String) {
    add("annotationProcessor", depName)
}