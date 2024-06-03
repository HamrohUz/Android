plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("convention.feature.compose")
}

android {
    namespace = "uz.hamroh.ui"
}

dependencies {
    implementation(libs.cicerone)
    api(platform(libs.compose.bom))
    api(libs.core.ktx)
    api(libs.lifecycle.runtime.ktx)
    api(libs.bundles.compose)
    api(libs.bundles.activity)
    implementation(project(":core:coroutines"))
}