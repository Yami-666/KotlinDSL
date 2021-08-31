package project_config

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.dagger2() {
    compileOnly(Dependencies.dagger)
    implementation(Dependencies.dagger_android)
    kapt(Dependencies.dagger_compiler)
    kapt(Dependencies.dagger_android_processor)
}

fun DependencyHandler.core() {
    implementation(Dependencies.std_lib)
    implementation(Dependencies.core_ktx)
}

fun DependencyHandler.compose() {
    implementation (Dependencies.compose_ui)
    implementation (Dependencies.compose_app_compat)
    implementation (Dependencies.compose_tool_preview)
    implementation (Dependencies.compose_activity)
    androidTestImplementation (Dependencies.compose_junit_test)
    debugImplementation (Dependencies.compose_ui_tooling)
}

fun DependencyHandler.integrationTests() {
    testImplementation(Dependencies.junit_test)
    androidTestImplementation(Dependencies.junit_android_ext)
    androidTestImplementation(Dependencies.espresso_ui_test)
}

fun DependencyHandler.ktx() {
    implementation(Dependencies.lifecycle_ktx)
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