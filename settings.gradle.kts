import org.gradle.api.initialization.resolve.RepositoriesMode

include(":feature:trip:driver")


include(":feature:trip:passenger")


include(":core:store")


include(":feature:profile")


include(":feature:chat")


include(":feature:home")


pluginManagement {
    includeBuild("build-logic")
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
include(":core:coroutines")
include(":navigation")
include(":feature:authorization")
