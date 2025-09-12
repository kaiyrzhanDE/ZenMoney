import kaiyrzhan.de.mvkitchen.gradle.buildApplicationId

plugins {
    alias(libs.plugins.mvkitchen.android.library)
    alias(libs.plugins.mvkitchen.jetpack.compose)
}

android {
    namespace = buildApplicationId("library.android")
}
