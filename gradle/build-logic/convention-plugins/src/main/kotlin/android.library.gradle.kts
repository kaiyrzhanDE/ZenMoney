import kaiyrzhan.de.zenmoney.gradle.ProjectTargets
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.configureCommonBuildTypes
import kaiyrzhan.de.zenmoney.gradle.implementation
import kaiyrzhan.de.zenmoney.gradle.javaVersion
import kaiyrzhan.de.zenmoney.gradle.jvmTarget
import kaiyrzhan.de.zenmoney.gradle.kotlinJvmCompilerOptions
import kaiyrzhan.de.zenmoney.gradle.libs

plugins.applyIfNeeded(libs.plugins.android.library.get().pluginId)

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}

configureCommonBuildTypes()

kotlinJvmCompilerOptions {
    jvmTarget.set(libs.jvmTarget(ProjectTargets.Android))
    freeCompilerArgs.add("-Xjdk-release=${libs.javaVersion(ProjectTargets.Android)}")
}

plugins.apply(libs.plugins.zenmoney.android.base.get().pluginId)

