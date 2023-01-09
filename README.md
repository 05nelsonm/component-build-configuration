# component-build-configuration
[![badge-license]][url-license]
[![badge-latest-release]][url-latest-release]

[![badge-kotlin]][url-kotlin]

![badge-platform-android]
![badge-platform-jvm]
![badge-platform-js]
![badge-platform-js-node]
![badge-platform-linux]
![badge-platform-macos]
![badge-platform-ios]
![badge-platform-tvos]
![badge-platform-watchos]
![badge-platform-wasm]
![badge-platform-windows]
![badge-support-android-native]
![badge-support-apple-silicon]
![badge-support-js-ir]

A Kotlin Multiplatform library for utilizing `BuildConfiguration` details from common code.

### Get Started

<!-- TAG_VERSION -->

```kotlin
// build.gradle.kts
dependencies {
    implementation("io.matthewnelson.kotlin-components:build-configuration:3.0.5")
}
```

<!-- TAG_VERSION -->

```groovy
// build.gradle
dependencies {
    implementation "io.matthewnelson.kotlin-components:build-configuration:3.0.5"
}
```

### Kotlin Version Compatibility

**Note:** as of `2.0.0`, the experimental memory model for KotlinNative is enabled.

<!-- TAG_VERSION -->

| build-configuration | kotlin |
|:-------------------:|:------:|
|        3.0.5        | 1.8.0  |
|        3.0.4        | 1.7.20 |
|        3.0.3        | 1.6.21 |
|        3.0.2        | 1.6.21 |
|        3.0.1        | 1.6.21 |
|        3.0.0        | 1.6.10 |
|        2.0.0        | 1.6.10 |
|          1          | 1.5.31 |

### Usage (Android example using Hilt dependency injection)

```kotlin
// module :app

import io.matthewnelson.component.build.configuration.BuildConfiguration

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideBuildConfig(): BuildConfiguration =
        BuildConfiguration(
            applicationId = BuildConfig.APPLICATION_ID,
            versionName = BuildConfig.VERSION_NAME,
            versionCode = BuildConfig.VERSION_CODE,
            isDebug = BuildConfig.DEBUG,
            variant = BuildConfig.BUILD_TYPE,
            flavor = BuildConfig.FLAVOR,
        )
    
    @Provides
    fun provideMyMultiPlatformClass(
        buildConfiguration: BuildConfiguration
    ): MyMultiPlatformClass =
        MyMultiPlatformClass(buildConfiguration)
}

// module :core (kotlin multiplatform project where class is in commonMain)
class MyMultiPlatformClass(private val config: BuildConfiguration) {
    
    fun doSomethingWithString(string: String): String {
        if (config.isDebug) {
            // do this
        } else {
            // do that
        }
    }
}
```

### Git

This project utilizes git submodules. You will need to initialize them when
cloning the repository via:

```bash
$ git clone --recursive https://github.com/05nelsonm/component-build-configuration.git
```

If you've already cloned the repository, run:
```bash
$ git checkout master
$ git pull
$ git submodule update --init
```

In order to keep submodules updated when pulling the latest code, run:
```bash
$ git pull --recurse-submodules
```

<!-- TAG_VERSION -->
[badge-latest-release]: https://img.shields.io/badge/latest--release-3.0.5-blue.svg?style=flat
[badge-license]: https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat

<!-- TAG_DEPENDENCIES -->
[badge-kotlin]: https://img.shields.io/badge/kotlin-1.8.0-blue.svg?logo=kotlin

<!-- TAG_PLATFORMS -->
[badge-platform-android]: http://img.shields.io/badge/-android-6EDB8D.svg?style=flat
[badge-platform-jvm]: http://img.shields.io/badge/-jvm-DB413D.svg?style=flat
[badge-platform-js]: http://img.shields.io/badge/-js-F8DB5D.svg?style=flat
[badge-platform-js-node]: https://img.shields.io/badge/-nodejs-68a063.svg?style=flat
[badge-platform-linux]: http://img.shields.io/badge/-linux-2D3F6C.svg?style=flat
[badge-platform-macos]: http://img.shields.io/badge/-macos-111111.svg?style=flat
[badge-platform-ios]: http://img.shields.io/badge/-ios-CDCDCD.svg?style=flat
[badge-platform-tvos]: http://img.shields.io/badge/-tvos-808080.svg?style=flat
[badge-platform-watchos]: http://img.shields.io/badge/-watchos-C0C0C0.svg?style=flat
[badge-platform-wasm]: https://img.shields.io/badge/-wasm-624FE8.svg?style=flat
[badge-platform-windows]: http://img.shields.io/badge/-windows-4D76CD.svg?style=flat
[badge-support-android-native]: http://img.shields.io/badge/support-[AndroidNative]-6EDB8D.svg?style=flat
[badge-support-apple-silicon]: http://img.shields.io/badge/support-[AppleSilicon]-43BBFF.svg?style=flat
[badge-support-js-ir]: https://img.shields.io/badge/support-[js--IR]-AAC4E0.svg?style=flat

[url-latest-release]: https://github.com/05nelsonm/component-build-configuration/releases/latest
[url-license]: https://www.apache.org/licenses/LICENSE-2.0.txt
[url-kotlin]: https://kotlinlang.org
