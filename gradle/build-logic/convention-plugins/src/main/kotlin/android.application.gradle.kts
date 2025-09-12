import kaiyrzhan.de.mvkitchen.gradle.ProjectTargets
import kaiyrzhan.de.mvkitchen.gradle.androidConfig
import kaiyrzhan.de.mvkitchen.gradle.applicationConfig
import kaiyrzhan.de.mvkitchen.gradle.applicationDefaultConfig
import kaiyrzhan.de.mvkitchen.gradle.applyIfNeeded
import kaiyrzhan.de.mvkitchen.gradle.configureAppBuildTypes
import kaiyrzhan.de.mvkitchen.gradle.implementation
import kaiyrzhan.de.mvkitchen.gradle.jvmTarget
import kaiyrzhan.de.mvkitchen.gradle.kotlinJvmCompilerOptions
import kaiyrzhan.de.mvkitchen.gradle.libs

plugins.applyIfNeeded(libs.plugins.android.application.get().pluginId)

applicationDefaultConfig {
    this.applicationId = ProjectTargets.Android.APPLICATION_ID
    targetSdk = libs.versions.android.targetSdk.get().toInt()
    versionCode = libs.versions.app.versionCode.get().toInt()
    versionName = libs.versions.app.versionName.get()
}

configureAppBuildTypes()

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.androidx.activity.compose)
}

kotlinJvmCompilerOptions {
    jvmTarget.set(libs.jvmTarget(ProjectTargets.Android))
}

plugins.apply(libs.plugins.mvkitchen.android.base.get().pluginId)
