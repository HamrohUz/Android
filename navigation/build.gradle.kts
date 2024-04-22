plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
    id("convention.common")
}

android {
    namespace = "uz.hamroh.navigation"
}

dependencies {
    api(libs.cicerone)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}