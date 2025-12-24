package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.composeExtension
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.kmpConfig
import kaiyrzhan.de.zenmoney.gradle.libs

plugins.applyIfNeeded(libs.plugins.zenmoney.jetbrains.compose.base.get().pluginId)

kmpConfig {
    sourceSets {
        val desktopMain by getting
        desktopMain.dependencies {
            implementation(composeExtension.dependencies.desktop.common)
            implementation(composeExtension.dependencies.desktop.currentOs)
        }
    }
}
