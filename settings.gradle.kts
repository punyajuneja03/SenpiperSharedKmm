pluginManagement {
    repositories {
        google()       // ✅ Required for Android plugin
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "shared"
include(":shared")