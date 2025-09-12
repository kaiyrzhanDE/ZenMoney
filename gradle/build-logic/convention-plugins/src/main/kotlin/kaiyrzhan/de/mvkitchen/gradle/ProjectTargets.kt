package kaiyrzhan.de.mvkitchen.gradle

sealed interface ProjectTargets {
    sealed interface JvmTarget

    object Android : ProjectTargets, JvmTarget
}
