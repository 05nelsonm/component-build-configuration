package io.matthewnelson.component.build.configuration

/**
 * Enable the passing of BuildConfig information across modules
 *
 * @throws [IllegalStateException] when:
 *  - [applicationId] is empty
 *  - [versionName] is empty
 *  - [versionCode] is less than or equal to 0
 * */
data class BuildConfiguration(
    val applicationId: String,
    val versionName: String,
    val versionCode: Int,
    val isDebug: Boolean,
    val platform: Platform,
    val variant: String = if (isDebug) "debug" else "release"
) {

    init {
        check(applicationId.isNotEmpty()) { "applicationId cannot be empty" }
        check(versionName.isNotEmpty()) { "versionName cannot be empty" }
        check(versionCode > 0) { "versionCode must be greater than 0" }
    }

    sealed class Platform {

        override fun equals(other: Any?): Boolean {
            return other != null && other is Platform && other.toString() == toString()
        }

        override fun hashCode(): Int {
            return 17 * 31 + toString().hashCode()
        }

        class Android: Platform() { override fun toString(): String = "Platform.Android" }
        class Jvm: Platform() { override fun toString(): String = "Platform.Jvm" }
        class Js: Platform() { override fun toString(): String = "Platform.Js" }
        class Darwin: Platform() { override fun toString(): String = "Platform.Darwin" }
        class Linux: Platform() { override fun toString(): String = "Platform.Linux" }
        class Mingw: Platform() { override fun toString(): String = "Platform.Mingw" }
    }

}
