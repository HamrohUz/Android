package uz.hamroh.buildlogic.plugins

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("UnstableApiUsage")
class FeatureComposePlugin : BasePlugin() {
    override fun apply(target: Project) = target.applyAndroid()

    private fun Project.applyAndroid() {

        pluginManager.apply {
            apply("convention.common")
        }

        android {
            setCompileSdkVersion(34)

            defaultConfig{
                targetSdk = 34
            }
            buildFeatures.apply {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = getVersion(getVersionCatalog(),
                    DependenciesHelper.Versions.composeCompiler
                )
            }
        }

        dependencies {
            implementation(getVersionCatalog(), DependenciesHelper.Libs.compose)
        }
    }
}