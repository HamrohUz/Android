pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Hamroh"
include(":app")
include(":core:network")
include(":core:ui")
include(":core:di")
include(":core:coroutines")
include(":navigation")
include(":feature:authorization")
