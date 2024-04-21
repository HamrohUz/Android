@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
    id("convention.common")
}

android {
    namespace = "uz.hamroh.di"
}

dependencies {
    api(libs.hilt.android)
    ksp(libs.hilt.compiler)
}