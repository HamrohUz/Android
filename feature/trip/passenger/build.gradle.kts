plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("convention.feature.compose")
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
}

android {
    namespace = "uz.hamroh.trip.passenger"
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