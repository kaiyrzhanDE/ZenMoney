package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.libs
import kaiyrzhan.de.zenmoney.gradle.androidConfig
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded

plugins.applyIfNeeded(libs.plugins.jetbrains.compose.compiler.get().pluginId)

androidConfig {
    buildFeatures {
        compose = true
    }
}