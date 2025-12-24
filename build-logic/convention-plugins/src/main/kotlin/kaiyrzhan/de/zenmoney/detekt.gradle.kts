package kaiyrzhan.de.zenmoney

import io.gitlab.arturbosch.detekt.Detekt
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.detektConfig
import kaiyrzhan.de.zenmoney.gradle.detektPlugins
import kaiyrzhan.de.zenmoney.gradle.libs
import org.gradle.kotlin.dsl.withType
import kotlin.apply

plugins.applyIfNeeded(libs.plugins.detekt.get().pluginId)

detektConfig {
    toolVersion = libs.versions.detekt.get()

    config.setFrom(
        File(rootProject.rootDir, "config/detekt/detekt.yml"),
        File(rootProject.rootDir, "config/detekt/detekt-compose.yml"),
    )
    buildUponDefaultConfig = false
    allRules = false
    baseline = file("detekt-baseline.xml")
    disableDefaultRuleSets = false
    debug = false
    ignoreFailures = false
    parallel = true
}

tasks.withType<Detekt>()
    .configureEach {
        setSource(projectDir)
        include("**/src/*/kotlin/**/*.kt") // Include all Kotlin source files from all directories

        exclude(
            "build-logic", // Don't analyze Convention Plugin for the project
            "**/build/**", // Exclude all generated files from Gradle Build directory
        )

        with(this.project) {
            reports {
                xml.apply {
                    isEnabled = true
                    outputLocation.set(layout.buildDirectory.file("reports/detekt/detekt.xml"))
                }

                txt.apply {
                    isEnabled = true
                    outputLocation.set(layout.buildDirectory.file("reports/detekt/detekt.txt"))
                }

                html.apply {
                    isEnabled = true
                    outputLocation.set(layout.buildDirectory.file("reports/detekt/detekt.html"))
                }

                sarif.apply {
                    isEnabled = false
                    outputLocation.set(layout.buildDirectory.file("reports/detekt/detekt.sarif"))
                }

                md.apply {
                    // Required to fail Gradle task
                    isEnabled = true
                    outputLocation.set(layout.buildDirectory.file("reports/detekt/detekt.md"))
                }
            }
        }
    }

dependencies {
    detektPlugins(libs.detektplugin.nlopez.composeRules)
}
