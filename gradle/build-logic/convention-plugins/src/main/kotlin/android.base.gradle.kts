import kaiyrzhan.de.mvkitchen.gradle.ProjectTargets
import kaiyrzhan.de.mvkitchen.gradle.androidConfig
import kaiyrzhan.de.mvkitchen.gradle.applyIfNeeded
import kaiyrzhan.de.mvkitchen.gradle.buildNameSpace
import kaiyrzhan.de.mvkitchen.gradle.enableExplicitApi
import kaiyrzhan.de.mvkitchen.gradle.javaVersion
import kaiyrzhan.de.mvkitchen.gradle.libs

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
