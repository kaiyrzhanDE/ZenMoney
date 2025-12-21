import kaiyrzhan.de.zenmoney.gradle.ProjectTargets
import kaiyrzhan.de.zenmoney.gradle.applicationDefaultConfig
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.configureAppBuildTypes
import kaiyrzhan.de.zenmoney.gradle.implementation
import kaiyrzhan.de.zenmoney.gradle.jvmTarget
import kaiyrzhan.de.zenmoney.gradle.kotlinJvmCompilerOptions
import kaiyrzhan.de.zenmoney.gradle.libs

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

plugins.apply(libs.plugins.zenmoney.android.base.get().pluginId)
