import kaiyrzhan.de.mvkitchen.gradle.BuildType

plugins {
    alias(libs.plugins.mvkitchen.android.application)
    alias(libs.plugins.mvkitchen.jetpack.compose)
}

android {
    buildTypes {
        getByName(BuildType.RELEASE.toString()) {
            isMinifyEnabled = false
        }
    }
}