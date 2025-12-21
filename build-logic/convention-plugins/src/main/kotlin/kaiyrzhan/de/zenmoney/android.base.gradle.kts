package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.ProjectTargets
import kaiyrzhan.de.zenmoney.gradle.androidConfig
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.buildNameSpace
import kaiyrzhan.de.zenmoney.gradle.enableExplicitApi
import kaiyrzhan.de.zenmoney.gradle.javaVersion
import kaiyrzhan.de.zenmoney.gradle.libs

plugins.applyIfNeeded(libs.plugins.kotlin.android.get().pluginId)

androidConfig {
    namespace = buildNameSpace()
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    compileOptions {
        val javaVersion = libs.javaVersion(ProjectTargets.Android)
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
}

enableExplicitApi()
