plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
    id("convention.common")
}

android {
    namespace = "uz.hamroh.network"

    defaultConfig {

        buildFeatures {
            buildConfig = true
        }

        buildConfigField("String", "BACKEND_URL", "\"http://147.45.146.93:9000/\"")
    }
}

dependencies {
    implementation(libs.bundles.network)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}