package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.androidConfig
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.implementation
import kaiyrzhan.de.zenmoney.gradle.libs

plugins.applyIfNeeded(libs.plugins.kotlin.compose.get().pluginId)

androidConfig {
    buildFeatures {
        compose = true
    }
}

project.dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
}
