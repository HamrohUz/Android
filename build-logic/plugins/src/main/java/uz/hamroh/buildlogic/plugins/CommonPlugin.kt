package uz.hamroh.buildlogic.plugins

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class CommonPlugin : BasePlugin() {
    override fun apply(target: Project) = target.applyAndroid()

    private fun Project.applyAndroid() {
        android {
            setCompileSdkVersion(34)
            buildToolsVersion = "34.0.0"
            defaultConfig {

                minSdk = 26
                targetSdk = 34
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_19
                targetCompatibility = JavaVersion.VERSION_19
            }



            tasks.withType<KotlinCompile>().configureEach {
                kotlinOptions {
                    jvmTarget = "19"
                }
            }
        }
    }
}