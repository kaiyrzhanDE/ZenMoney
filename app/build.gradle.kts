import kaiyrzhan.de.zenmoney.gradle.ProjectTargets
import kaiyrzhan.de.zenmoney.gradle.buildNameSpace
import kaiyrzhan.de.zenmoney.gradle.configureAppBuildTypes
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.zenmoney.kmp.library.all)
    alias(libs.plugins.zenmoney.jetbrains.compose.all)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.uikit)
            implementation(libs.kotlinx.serialization.json)
        }

        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.appcompat)
            implementation(libs.androidx.material)
        }
    }
}

compose.resources {
    publicResClass = false
    generateResClass = always
}

compose.desktop {
    application {
        mainClass = "kaiyrzhan.de.zenmoney.app.ZenMoney"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = project.name
            packageVersion = "1.0.0"

//            windows {
//                iconFile.set(project.file("src/desktopMain/resources/icons/ic_app_msi.ico"))
//            }
//
//            macOS {
//                iconFile.set(project.file("src/desktopMain/resources/icons/ic_app_dmg.icns"))
//            }
//
//            linux {
//                iconFile.set(project.file("src/desktopMain/resources/icons/ic_app_deb.png"))
//            }
        }
    }
}

android {
    namespace = buildNameSpace()
    defaultConfig {
        applicationId = ProjectTargets.Android.APPLICATION_ID
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = libs.versions.app.versionCode.get().toInt()
        versionName = libs.versions.app.versionName.get()
    }

    configureAppBuildTypes()

    androidResources {
        generateLocaleConfig = false
        localeFilters += setOf("ru","en")
    }

    lint {
        checkReleaseBuilds = false
        checkDependencies = true
        checkAllWarnings = false
        checkTestSources = false
        checkGeneratedSources = false
    }

    buildFeatures {
        buildConfig = true
    }
}