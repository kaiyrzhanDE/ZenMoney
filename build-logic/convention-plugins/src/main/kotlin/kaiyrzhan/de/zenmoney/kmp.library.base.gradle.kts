package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.libs
import kaiyrzhan.de.zenmoney.gradle.kmpConfig
import kaiyrzhan.de.zenmoney.gradle.kotlinOptIns
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.enableExplicitApi
import kotlin.jvm.kotlin

plugins.applyIfNeeded(libs.plugins.jetbrains.kotlin.multiplatform.get().pluginId)

kmpConfig {
    compilerOptions {
        optIn.addAll(kotlinOptIns)
        freeCompilerArgs.add("-Xexpect-actual-classes")

        // Code running from IDEA/Android Studio
        if (System.getProperty("idea.active") == "true"){
            // Turn on debug mode
            freeCompilerArgs = listOf("-Xdebug")
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.androidx.annotation)
            implementation(libs.kotlinx.datetime)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotlinx.coroutines.test)
        }
    }
}