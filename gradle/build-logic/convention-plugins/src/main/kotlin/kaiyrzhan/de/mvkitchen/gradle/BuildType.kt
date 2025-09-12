package kaiyrzhan.de.mvkitchen.gradle

enum class BuildType(val type: String) {
    RELEASE("release"),
    DEBUG("debug");

    override fun toString(): String {
        return type
    }
}