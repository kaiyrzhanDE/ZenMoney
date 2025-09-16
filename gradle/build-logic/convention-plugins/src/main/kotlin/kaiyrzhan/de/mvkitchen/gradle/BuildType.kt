@file:Suppress("ktlint")

package kaiyrzhan.de.mvkitchen.gradle

import com.android.build.api.dsl.BuildType as CommonBuildType
import com.android.build.gradle.ProguardFiles.getDefaultProguardFile
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project

internal enum class BuildType(
    val type: String,
    val applicationIdSuffix: String?,
    val versionNameSuffix: String?,
    val isMinifyEnabled: Boolean,
) {
    RELEASE(
        type = "release",
        applicationIdSuffix = null,
        versionNameSuffix = null,
        isMinifyEnabled = true,
    ),
    DEBUG(
        type = "debug",
        applicationIdSuffix = "debug",
        versionNameSuffix = "debug",
        isMinifyEnabled = false,
    );

    override fun toString(): String = type

    fun isReleaseBuild(): Boolean = this == RELEASE
}

internal fun <BuildTypeT> NamedDomainObjectContainer<BuildTypeT>.getByType(
    buildType: BuildType,
    block: BuildTypeT.(BuildType) -> Unit,
) {
    getByName(buildType.type) { block(buildType) }
}

private fun CommonBuildType.applyCommonConfig(type: BuildType, project: Project) {
    isMinifyEnabled = type.isMinifyEnabled
    if (type.isReleaseBuild()) {
        proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt", project.layout.buildDirectory),
            project.file("proguard-rules.pro")
        )
    }
}

internal fun Project.configureCommonBuildTypes() {
    androidConfig {
        buildTypes {
            BuildType.values().forEach { type ->
                getByType(type) {
                    applyCommonConfig(type, project)
                }
            }
        }
    }
}

private fun String.withPrefix(prefix: String): String? {
    return this
        .takeIf { it.isNotBlank() }
        .let { "$prefix$it" }
}

internal fun Project.configureAppBuildTypes() {
    applicationConfig {
        buildTypes {
            BuildType.values().forEach { type ->
                getByType(type) {
                    applyCommonConfig(type, project)
                    applicationIdSuffix = type.applicationIdSuffix?.withPrefix(".")
                    versionNameSuffix = type.versionNameSuffix?.withPrefix("-")
                }
            }
        }
    }
}
