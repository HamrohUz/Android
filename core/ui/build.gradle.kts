@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("convention.feature.compose")
}

android {
    namespace = "uz.hamroh.ui"
}

dependencies {
    api(platform(libs.compose.bom))
    api(libs.core.ktx)
    api(libs.lifecycle.runtime.ktx)
    api(libs.bundles.compose)
    api(libs.bundles.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}