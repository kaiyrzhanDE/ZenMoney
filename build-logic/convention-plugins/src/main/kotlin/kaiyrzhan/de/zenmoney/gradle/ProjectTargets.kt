@file:Suppress("ktlint")

package kaiyrzhan.de.zenmoney.gradle

/**
 * Targets for the project
 */
public sealed interface ProjectTargets {
    sealed interface JvmTarget

    object Desktop : ProjectTargets, JvmTarget

    object Android : ProjectTargets, JvmTarget {
        const val APPLICATION_ID = "kaiyrzhan.de.zenmoney"
    }

    sealed interface IOS : ProjectTargets {
        sealed interface Simulator

        object SimulatorX64 : IOS, Simulator

        object SimulatorArm64 : IOS, Simulator

        object ARM64 : IOS
    }
}

