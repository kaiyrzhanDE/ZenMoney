import kaiyrzhan.de.zenmoney.gradle.buildNameSpace

plugins {
    alias(libs.plugins.zenmoney.kmp.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.jetbrains.compose.runtime)
            api(libs.jetbrains.compose.foundation)
            api(libs.jetbrains.compose.material3.core)
            api(libs.jetbrains.compose.ui.toolingPreview)
            api(libs.jetbrains.compose.ui.core)
        }
    }
}

android {
    namespace = buildNameSpace()
}

compose.resources {
    publicResClass = true
    generateResClass = always
}
