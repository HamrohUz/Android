plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinAndroidKsp)
    id("convention.feature.compose")
    alias(libs.plugins.hiltAndroid)
}

android {
    namespace = "uz.hamroh.chat"
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":core:coroutines"))
    implementation(project(":navigation"))
    implementation(project(":core:store"))
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}