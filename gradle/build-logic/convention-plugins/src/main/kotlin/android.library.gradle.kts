import kaiyrzhan.de.mvkitchen.gradle.ProjectTargets
import kaiyrzhan.de.mvkitchen.gradle.applyIfNeeded
import kaiyrzhan.de.mvkitchen.gradle.implementation
import kaiyrzhan.de.mvkitchen.gradle.javaVersion
import kaiyrzhan.de.mvkitchen.gradle.jvmTarget
import kaiyrzhan.de.mvkitchen.gradle.kotlinJvmCompilerOptions
import kaiyrzhan.de.mvkitchen.gradle.libs

plugins.applyIfNeeded(libs.plugins.android.library.get().pluginId)

project.dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}

kotlinJvmCompilerOptions {
    jvmTarget.set(libs.jvmTarget(ProjectTargets.Android))
    freeCompilerArgs.add("-Xjdk-release=${libs.javaVersion(ProjectTargets.Android)}")
}

plugins.apply(libs.plugins.mvkitchen.android.base.get().pluginId)

