package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.libs

plugins.applyIfNeeded(libs.plugins.zenmoney.kmp.library.all.get().pluginId)
plugins.applyIfNeeded(libs.plugins.zenmoney.jetbrains.compose.all.get().pluginId)