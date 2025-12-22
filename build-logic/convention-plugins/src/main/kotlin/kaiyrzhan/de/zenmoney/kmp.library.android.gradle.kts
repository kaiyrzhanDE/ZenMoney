package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.ProjectTargets
import kaiyrzhan.de.zenmoney.gradle.androidConfig
import kaiyrzhan.de.zenmoney.gradle.libs
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.jvmTarget
import kaiyrzhan.de.zenmoney.gradle.kmpConfig

plugins.applyIfNeeded(libs.plugins.jetbrains.kotlin.multiplatform.get().pluginId)
plugins.applyIfNeeded(
    libs.plugins.android.library.get().pluginId,
    libs.plugins.android.application.get().pluginId,
)
plugins.applyIfNeeded(libs.plugins.zenmoney.kmp.library.base.get().pluginId)

kmpConfig {
    applyDefaultHierarchyTemplate {
        common {
            group("nonAndroid") {
                withIos()
                withIosX64()
                withIosArm64()
                withIosSimulatorArm64()
                withNative()
                withJvm()
            }
        }
    }

    androidTarget {
        compilerOptions {
            jvmTarget.set(libs.jvmTarget(ProjectTargets.Android))
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.kotlinx.coroutines.android)
        }

        named("nonAndroidMain")

        val androidUnitTest by getting
        androidUnitTest.dependencies {
            implementation(libs.kotlin.test.junit)
            implementation(libs.junit)
        }
    }
}

androidConfig {
    sourceSets["main"].apply {
        setRoot("src/androidMain")
    }
}

plugins.applyIfNeeded(libs.plugins.zenmoney.android.base.get().pluginId)

