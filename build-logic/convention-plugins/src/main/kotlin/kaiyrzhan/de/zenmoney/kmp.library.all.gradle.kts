package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.libs

plugins.applyIfNeeded(libs.plugins.zenmoney.kmp.library.desktop.get().pluginId)
plugins.applyIfNeeded(libs.plugins.zenmoney.kmp.library.android.get().pluginId)
plugins.applyIfNeeded(libs.plugins.zenmoney.kmp.library.ios.get().pluginId)
