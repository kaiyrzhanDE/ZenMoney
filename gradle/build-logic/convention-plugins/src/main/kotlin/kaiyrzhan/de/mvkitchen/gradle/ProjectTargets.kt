@file:Suppress("ktlint")

package kaiyrzhan.de.mvkitchen.gradle

sealed interface ProjectTargets {
    sealed interface JvmTarget

    object Android : ProjectTargets, JvmTarget {
        const val APPLICATION_ID = "kaiyrzhan.de.mvkitchen"
    }
}
