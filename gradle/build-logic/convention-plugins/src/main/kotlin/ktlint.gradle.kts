import kaiyrzhan.de.zenmoney.gradle.KTLINT
import kaiyrzhan.de.zenmoney.gradle.ktLint
import kaiyrzhan.de.zenmoney.gradle.applyIfNeeded
import kaiyrzhan.de.zenmoney.gradle.libs

plugins.applyIfNeeded(libs.plugins.java.library.get().pluginId)

private val ktLintConfig = configurations.create(KTLINT)

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
