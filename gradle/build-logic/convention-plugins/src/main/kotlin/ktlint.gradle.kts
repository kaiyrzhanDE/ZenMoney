import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.libs
import org.gradle.api.artifacts.ExternalModuleDependency

plugins.applyIfNeeded(libs.plugins.java.library.get().pluginId)

private val ktLintConfigName = "ktlint"
private val ktLintConfig = configurations.create(ktLintConfigName)

private fun DependencyHandlerScope.ktLint(
    dependencyConfiguration : ExternalModuleDependency.() -> Unit,
) {
    ktLintConfigName(libs.ktlint.cli, dependencyConfiguration)
}

dependencies {
    ktLint {
        attributes {
            attribute(
                Bundling.BUNDLING_ATTRIBUTE,
                getObjects().named<Bundling>(Bundling.EXTERNAL),
            )
        }
    }
}

private val sources = listOf(
    "!**/build/**",
    "**/src/**/*.kt",
)
private val reportsDirPath = project.layout.buildDirectory.dir("reports/ktlint").get().asFile.path
private val ktLintCliMainClass = "com.pinterest.ktlint.Main"
private val reportArgs = listOf(
    "--reporter=plain",
    "--reporter=checkstyle,output=$reportsDirPath/ktlint.xml",
    "--reporter=html,output=$reportsDirPath/ktlint.html",
)

val ktLintCheckTask = tasks.register<JavaExec>("ktlintCheck") {
    group = "verification"
    description = "Check Kotlin code style."
    classpath = ktLintConfig
    mainClass = ktLintCliMainClass
    args = reportArgs + sources
}

tasks.named("check") {
    dependsOn(ktLintCheckTask)
}

tasks.register<JavaExec>("ktlintFormat") {
    group = "formatting"
    description = "Fix Kotlin code style deviations."
    classpath = ktLintConfig
    mainClass = ktLintCliMainClass
    jvmArgs = listOf("--add-opens=java.base/java.lang=ALL-UNNAMED")
    // see https://pinterest.github.io/ktlint/install/cli/#command-line-usage for more information
    args = listOf("-F") + sources
}
