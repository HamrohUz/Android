package uz.hamroh.buildlogic.plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType

fun Project.getVersionCatalog(): VersionCatalog =
    this.extensions.getByType<VersionCatalogsExtension>().named(LibNameDirectory)

fun Project.android(action: BaseExtension.() -> Unit) = (extensions["android"] as BaseExtension).run(action)

abstract class BasePlugin : Plugin<Project> {
    protected fun DependencyHandler.implementation(versionCatalog: VersionCatalog, library: LibraryDependence) {
        versionCatalog.findLibrary(library.name).ifPresent { implementation(it) }
    }

    protected fun DependencyHandler.testImplementation(versionCatalog: VersionCatalog, library: LibraryDependence) {
        versionCatalog.findLibrary(library.name).ifPresent { testImplementation(it) }
    }

    protected fun DependencyHandler.androidTestImplementation(versionCatalog: VersionCatalog, library: LibraryDependence) {
        versionCatalog.findLibrary(library.name).ifPresent { androidTestImplementation(it) }
    }

    protected fun DependencyHandler.api(versionCatalog: VersionCatalog, library: LibraryDependence) {
        versionCatalog.findLibrary(library.name).ifPresent { api(it) }
    }

    protected fun getVersion(versionCatalog: VersionCatalog, versionDependence: VersionDependence): String {
        return versionCatalog.findVersion(versionDependence.name).get().requiredVersion
    }

    protected fun DependencyHandler.kapt(versionCatalog: VersionCatalog, library: LibraryDependence) {
        versionCatalog.findLibrary(library.name).ifPresent { kapt(it) }
    }

    protected fun DependencyHandler.annotationProcessor(depName: String) {
        add("annotationProcessor", depName)
    }

    private fun DependencyHandler.kapt(dependencyNotation: Any) {
        add("kapt", dependencyNotation)
    }

    private fun DependencyHandler.api(dependencyNotation: Any) {
        add("api", dependencyNotation)
    }

    protected fun DependencyHandler.implementation(dependencyNotation: Any) {
        add("implementation", dependencyNotation)
    }

    protected fun DependencyHandler.testImplementation(dependencyNotation: Any) {
        add("testImplementation", dependencyNotation)
    }

    protected fun DependencyHandler.androidTestImplementation(dependencyNotation: Any) {
        add("androidTestImplementation", dependencyNotation)
    }
}