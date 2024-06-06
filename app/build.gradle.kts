plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
    id("convention.feature.compose")
}

android {
    namespace = "uz.hamroh"

}

dependencies {
    implementation(project(":navigation"))
    implementation(project(":feature:authorization"))
    implementation(project(":feature:home"))
    implementation(project(":feature:profile"))
    implementation(project(":core:ui"))
    implementation(project(":core:network"))
    implementation(project(":core:coroutines"))
    implementation(project(":core:store"))
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}