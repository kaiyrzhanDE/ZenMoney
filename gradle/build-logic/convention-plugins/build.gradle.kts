plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "kaiyrzhan.de.mvkitchen.gradle"

dependencies {
    implementation(libs.gradleplugins.android)
    implementation(libs.gradleplugins.kotlin)
    implementation(libs.gradleplugins.compose.compiler)
    implementation(libs.gradleplugins.detekt)

    // Workaround for version catalog working inside precompiled scripts
    // Issue - https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

java {
    val javaVersion = JavaVersion.toVersion(libs.versions.gradleplugins.javaVersion.get().toInt())
    targetCompatibility = javaVersion
    sourceCompatibility = javaVersion
}
