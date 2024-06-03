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

        buildConfigField("String", "BACKEND_URL", "\"http://185.247.17.206:9000/\"")
    }
}

dependencies {
    api(libs.bundles.network)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}