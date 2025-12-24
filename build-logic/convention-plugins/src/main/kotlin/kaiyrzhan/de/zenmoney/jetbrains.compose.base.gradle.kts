package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.libs
import kaiyrzhan.de.zenmoney.gradle.composeExtension
import kaiyrzhan.de.zenmoney.gradle.kmpConfig

plugins.applyIfNeeded(libs.plugins.jetbrains.compose.compiler.get().pluginId)
plugins.applyIfNeeded(libs.plugins.jetbrains.compose.multiplatform.get().pluginId)

kmpConfig {
    sourceSets {
        commonMain.dependencies {
            implementation(composeExtension.dependencies.components.resources)
            implementation(composeExtension.dependencies.components.uiToolingPreview)

            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.jetbrains.lifecycle.viewmodel.compose)
            implementation(libs.androidx.lifecycle.runtime.compose)
        }
    }
}

