package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.libs

plugins.applyIfNeeded(libs.plugins.zenmoney.jetbrains.compose.android.get().pluginId)
plugins.applyIfNeeded(libs.plugins.zenmoney.jetbrains.compose.ios.get().pluginId)
plugins.applyIfNeeded(libs.plugins.zenmoney.jetbrains.compose.desktop.get().pluginId)
