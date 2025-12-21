@file:Suppress("ktlint")

package kaiyrzhan.de.zenmoney.gradle

sealed interface ProjectTargets {
    sealed interface JvmTarget

    object Android : ProjectTargets, JvmTarget {
        const val APPLICATION_ID = "kaiyrzhan.de.zenmoney"
    }
}
