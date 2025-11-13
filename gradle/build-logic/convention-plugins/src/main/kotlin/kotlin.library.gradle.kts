import kaiyrzhan.de.zenmoney.gradle.ProjectTargets
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.enableExplicitApi
import kaiyrzhan.de.zenmoney.gradle.javaConfig
import kaiyrzhan.de.zenmoney.gradle.javaVersion
import kaiyrzhan.de.zenmoney.gradle.jvmTarget
import kaiyrzhan.de.zenmoney.gradle.kotlinJvmCompilerOptions
import kaiyrzhan.de.zenmoney.gradle.libs

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