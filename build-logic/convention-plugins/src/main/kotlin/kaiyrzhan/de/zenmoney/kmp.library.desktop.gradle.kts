package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.DESKTOP
import kaiyrzhan.de.zenmoney.gradle.ProjectTargets
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.jvmTarget
import kaiyrzhan.de.zenmoney.gradle.kmpConfig
import kaiyrzhan.de.zenmoney.gradle.libs

plugins.applyIfNeeded(libs.plugins.jetbrains.kotlin.multiplatform.get().pluginId)
plugins.applyIfNeeded(libs.plugins.zenmoney.kmp.library.base.get().pluginId)

kmpConfig {
    jvm(DESKTOP) {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions.jvmTarget.set(libs.jvmTarget(ProjectTargets.Desktop))
            }
        }
    }

    sourceSets {
        val desktopMain by getting
        desktopMain.dependencies {
            implementation(libs.kotlinx.coroutines.swing)
        }

        val desktopTest by getting
        desktopTest.dependencies {
            implementation(libs.kotlin.test.junit)
        }
    }
}
