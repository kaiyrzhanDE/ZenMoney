import kaiyrzhan.de.mvkitchen.gradle.BuildType
import kaiyrzhan.de.mvkitchen.gradle.buildApplicationId

plugins {
    alias(libs.plugins.mvkitchen.android.application)
    alias(libs.plugins.mvkitchen.jetpack.compose)
}

android {
    namespace = buildApplicationId("app")

    buildTypes {
        getByName(BuildType.RELEASE.toString()) {
            isMinifyEnabled = false
        }
    }
}