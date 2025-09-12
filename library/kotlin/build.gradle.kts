import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

private val applicationId = "kaiyrzhan.de.mvkitchen.library.kotlin"
private val jdkVersion = libs.versions.android.javaVersion.get().toInt()

android {
    namespace = applicationId
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        this.applicationId = applicationId
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        val javaVersion = JavaVersion.toVersion(jdkVersion)
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
    buildFeatures {
        compose = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.valueOf("JVM_$jdkVersion"))
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
}