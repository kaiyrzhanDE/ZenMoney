import kaiyrzhan.de.mvkitchen.gradle.ProjectTargets
import kaiyrzhan.de.mvkitchen.gradle.applyIfNeeded
import kaiyrzhan.de.mvkitchen.gradle.enableExplicitApi
import kaiyrzhan.de.mvkitchen.gradle.javaConfig
import kaiyrzhan.de.mvkitchen.gradle.javaVersion
import kaiyrzhan.de.mvkitchen.gradle.jvmTarget
import kaiyrzhan.de.mvkitchen.gradle.kotlinJvmCompilerOptions
import kaiyrzhan.de.mvkitchen.gradle.libs

plugins.applyIfNeeded(libs.plugins.kotlin.jvm.get().pluginId)
plugins.applyIfNeeded(libs.plugins.java.library.get().pluginId)

javaConfig {
    val javaVersion = libs.javaVersion(ProjectTargets.Android)
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

kotlinJvmCompilerOptions {
    jvmTarget.set(libs.jvmTarget(ProjectTargets.Android))
}

enableExplicitApi()