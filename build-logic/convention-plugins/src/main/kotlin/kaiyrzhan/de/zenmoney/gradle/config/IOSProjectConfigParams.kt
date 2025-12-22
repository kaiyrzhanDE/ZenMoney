package kaiyrzhan.de.zenmoney.gradle.config

import org.gradle.api.Project

internal val supportedIOSTargetsParam = ProjectConfigParam(
    cmdParamName = "kmp.ios.platforms",
    androidLocalPropertyParamName = "kmp.ios.platforms",
    envParamName = "KMP_IOS_PLATFORMS",
    defaultValue = "arm64,simulatorArmX64,simulatorIntelX64",
)

enum class IOSPlatform(
    val value: String,
) {
    ARM_64("arm64"),
    SIMULATOR_ARM64("simulatorArmX64"),
    SIMULATOR_X64("simulatorIntelX64"),
    ;

    companion object {
        fun default(): List<IOSPlatform> {
            val currentOS = System.getProperty("os.name")
            return if (currentOS.contains("mac", ignoreCase = true)) values().toList() else emptyList()
        }
    }
}

val Project.kmpIosPlatforms: List<IOSPlatform>
    get() {
        val supportedIOSTargetsParamValue = readConfigParam(supportedIOSTargetsParam)
        if (supportedIOSTargetsParamValue == "none") {
            return emptyList()
        }

        return supportedIOSTargetsParamValue?.split(",")?.map { paramValue ->
            IOSPlatform.values().first { it.value == paramValue }
        } ?: IOSPlatform.default()
    }
