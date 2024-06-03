plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
    id("convention.feature.compose")
}

android {

    namespace = "uz.hamroh.trip"
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:coroutines"))
    implementation(project(":navigation"))
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}