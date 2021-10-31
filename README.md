# component-build-configuration

A small library supporting Kotlin Multiplatform for utilizing `BuildConfiguration` details
from common code and across modules.

A full list of other `kotlin-components` projects and their supported Kotlin Multiplatform
frameworks can be found [HERE](https://kotlin-components.matthewnelson.io)


### Get Started
```kotlin
// build.gradle.kts

dependencies {
    implementation("io.matthewnelson.kotlin-components:build-configuration:1")
}
```

```groovy
// build.gradle

dependencies {
    implementation "io.matthewnelson.kotlin-components:build-configuration:1"
}
```

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
            platform = BuildConfiguration.Platform.Android(),
            variant = BuildConfig.BUILD_TYPE // overloaded to be either "debug" or "release" depending on `isDebug`
        )
    
}

// module :core
class MyClass @Inject constructor(private val config: BuildConfiguration) {
    
    fun doSomethingWithString(string: String): String {
        if (config.debug) {
            // do this
        } else {
            // do that
        }
    }
    
    fun doSomethingBasedOnPlatform(string: String) {
        when (config.platform) {
            is Platform.Android -> { /* do something */ }
            is Platform.Jvm -> { /* do something */ }
            is Platform.Js -> { /* do something */ }
            is Platform.Darwin -> { /* do something */ }
            is Platform.Linux -> { /* do something */ }
            is Platform.Mingw -> { /* do something */ }
        }
    }
}
```

### Git

This project utilizes git submodules. You will need to initialize them when
cloning the repository via:

```bash
$ git clone --recursive https://github.com/05nelsonm/component-request.git
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
