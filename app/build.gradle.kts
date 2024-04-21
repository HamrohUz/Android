@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
    id("convention.feature.compose")
}

android {
    namespace = "uz.hamroh"
}

dependencies {
    //implementation(project(":core:di"))
    implementation(project(":core:ui"))
    implementation(project(":navigation"))
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}