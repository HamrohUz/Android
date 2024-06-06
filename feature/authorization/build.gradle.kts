plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("convention.feature.compose")
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
    alias(libs.plugins.gms)
}

android {
    namespace = "uz.hamroh.feature.authorization"

    defaultConfig {

        buildFeatures {
            buildConfig = true
        }

        buildConfigField(
            "String",
            "CLIENT_ID",
            "\"36304003459-2etgs8u016vovip7ve3kacoe7c3egjs2.apps.googleusercontent.com\""
        )
    }
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":core:coroutines"))
    implementation(project(":navigation"))
    implementation(project(":core:store"))
    implementation(libs.hilt.android)
    implementation(libs.play.services.auth.v2120)
    implementation(libs.play.services.auth.api.phone)
    ksp(libs.hilt.compiler)
}