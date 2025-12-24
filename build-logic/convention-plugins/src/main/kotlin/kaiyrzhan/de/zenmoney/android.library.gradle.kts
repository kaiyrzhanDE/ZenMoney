package kaiyrzhan.de.zenmoney

import kaiyrzhan.de.zenmoney.gradle.ProjectTargets
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.configureCommonBuildTypes
import kaiyrzhan.de.zenmoney.gradle.implementation
import kaiyrzhan.de.zenmoney.gradle.javaVersion
import kaiyrzhan.de.zenmoney.gradle.jvmTarget
import kaiyrzhan.de.zenmoney.gradle.kotlinJvmCompilerOptions
import kaiyrzhan.de.zenmoney.gradle.libs

plugins.applyIfNeeded(libs.plugins.android.library.get().pluginId)
if (plugins.hasPlugin(libs.plugins.jetbrains.kotlin.multiplatform.get().pluginId)) {
    plugins.applyIfNeeded(libs.plugins.jetbrains.kotlin.android.get().pluginId)
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.annotation)
}

configureCommonBuildTypes()

kotlinJvmCompilerOptions {
    jvmTarget.set(libs.jvmTarget(ProjectTargets.Android))
    freeCompilerArgs.add("-Xjdk-release=${libs.javaVersion(ProjectTargets.Android)}")
    freeCompilerArgs.add("-Xexpect-actual-classes")
}

plugins.apply(libs.plugins.zenmoney.android.base.get().pluginId)

