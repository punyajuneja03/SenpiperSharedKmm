plugins {
    kotlin("multiplatform") version "1.9.23" apply false
    kotlin("plugin.serialization") version "1.9.23" apply false
    id("com.android.library") version "8.3.0" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" apply false
    id("org.jetbrains.compose") version "1.6.10" apply false
    id("com.google.devtools.ksp") version "2.0.0-1.0.23" apply false
    id("androidx.room") version "2.7.0-alpha01" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
