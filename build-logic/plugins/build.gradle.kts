plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly("com.android.tools.build:gradle:8.3.2")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
}

gradlePlugin {
    plugins {
        register("common-plugin") {
            id = "convention.common"
            implementationClass = "uz.hamroh.buildlogic.plugins.CommonPlugin"
        }
        register("feature-compose-plugin") {
            id = "convention.feature.compose"
            implementationClass = "uz.hamroh.buildlogic.plugins.FeatureComposePlugin"
        }
        register("test-plugin") {
            id = "convention.testing"
            implementationClass = "uz.hamroh.buildlogic.plugins.TestingPlugin"
        }
    }
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_19
    targetCompatibility = JavaVersion.VERSION_19
}