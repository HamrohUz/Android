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
    implementation(project(":navigation"))
    implementation(project(":feature:authorization"))
    implementation(project(":feature:trip"))
    implementation(project(":core:ui"))
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}