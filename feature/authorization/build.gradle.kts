@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("convention.feature.compose")
}

android {
    namespace = "uz.hamroh.feature.authorization"
}

dependencies {
    implementation(project(":core:ui"))
}