package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.libs
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.kmpConfig
import kaiyrzhan.de.zenmoney.gradle.androidConfig
import kaiyrzhan.de.zenmoney.gradle.debugImplementation
import kaiyrzhan.de.zenmoney.gradle.composeExtension

plugins.applyIfNeeded(libs.plugins.zenmoney.jetbrains.compose.base.get().pluginId)
plugins.apply(libs.plugins.zenmoney.jetpack.compose.base.get().pluginId)

kmpConfig {
    androidConfig {
        buildFeatures {
            compose = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(composeExtension.dependencies.preview)
        }
    }
}

dependencies {
    debugImplementation(composeExtension.dependencies.uiTooling)
}