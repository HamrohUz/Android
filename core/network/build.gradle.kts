@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("convention.common")
}

android {
    namespace = "uz.hamroh.network"
}

dependencies {
    implementation(libs.core.ktx)
}