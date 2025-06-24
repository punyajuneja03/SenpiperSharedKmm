import org.jetbrains.kotlin.gradle.dsl.JvmTarget
plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
    id("org.jetbrains.compose") version "1.6.10"
    kotlin("plugin.serialization") version "1.9.23"
    id("com.google.devtools.ksp") version "2.0.0-1.0.23"
    id("androidx.room") version "2.7.0-alpha01"

}
val roomVersion = "2.7.0-alpha02"
val sqliteVersion = "2.5.0-alpha01"
val kspVersion = "1.9.23-1.0.19"
android {
    namespace = "com.example.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        compose = true
    }
    composeOptions {

        kotlinCompilerExtensionVersion = "1.6.0"
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

kotlin {

    // Target declarations - add or remove as needed below. These define
    // which platforms this KMP module supports.
    // See: https://kotlinlang.org/docs/multiplatform-discover-project.html#targets
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    // For iOS targets, this is also where you should
    // configure native binary output. For more information, see:
    // https://kotlinlang.org/docs/multiplatform-build-native-binaries.html#build-xcframeworks

    // A step-by-step guide on how to include this library in an XCode
    // project can be found here:
    // https://developer.android.com/kotlin/multiplatform/migrate
    val xcfName = "sharedKit"

    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    // Source set declarations.
    // Declaring a target automatically creates a source set with the same name. By default, the
    // Kotlin Gradle Plugin creates additional source sets that depend on each other, since it is
    // common to share sources between related targets.
    // See: https://kotlinlang.org/docs/multiplatform-hierarchy.html
    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.23")

                implementation("org.jetbrains.compose.runtime:runtime:1.6.10")
                implementation("org.jetbrains.compose.foundation:foundation:1.6.10")
                implementation("org.jetbrains.compose.material3:material3:1.6.10")
                implementation("org.jetbrains.compose.ui:ui:1.6.10")
                implementation("org.jetbrains.compose.components:components-resources:1.6.10")

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
                implementation("io.ktor:ktor-client-core:2.3.9")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.9")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.9")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

                implementation("androidx.room:room-runtime:$roomVersion")
                implementation("androidx.sqlite:sqlite-bundled:$sqliteVersion")
            }
        }

        commonTest {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test:1.9.23")
            }
        }

        androidMain {
            dependencies {
                // Add Android-specific dependencies here. Note that this source set depends on
                // commonMain by default and will correctly pull the Android artifacts of any KMP
                // dependencies declared in commonMain.
                implementation("io.ktor:ktor-client-core:2.3.9")
                implementation("io.ktor:ktor-client-okhttp:2.3.9")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.9")
                implementation("com.squareup.okhttp3:okhttp:4.12.0")
            }
        }


//        getByName("androidDeviceTest") {
//            dependencies {
//                implementation(libs.androidx.ui.test.runner)
//                implementation(libs.androidx.test.core)
//                implementation(libs.androidx.junit)
//            }
//        }

        iosMain {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:2.3.11")
                // Add iOS-specific dependencies here. This a source set created by Kotlin Gradle
                // Plugin (KGP) that each specific iOS target (e.g., iosX64) depends on as
                // part of KMP’s default source set hierarchy. Note that this source set depends
                // on common by default and will correctly pull the iOS artifacts of any
                // KMP dependencies declared in commonMain.
            }
        }
    }

}
room {
    schemaDirectory("$projectDir/schemas")
}
dependencies {
    add("ksp", "androidx.room:room-compiler:$roomVersion")
}