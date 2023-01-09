# CHANGELOG

## Version 3.0.5 (2023-01-09)
 - Updates `kotlin-components` submodule
     - Kotlin `1.7.20` -> `1.8.0`
     - Support new target:
         - `watchosDeviceArm64`

## Version 3.0.4 (2023-01-07)
 - Updates `kotlin-components` submodule
     - Kotlin `1.6.21` -> `1.7.20`
     - Support new targets:
         - `androidNativeArm32`
         - `androidNativeArm64`
         - `androidNativeX64`
         - `androidNativeX86`
         - `linuxArm64`
         - `wasm32`
 - Removes `data class` in favor of `class`
 - Prettifies `toString` output
 - Fixes check for `applicationId` and `versionName` by now checking `isBlank` 
   instead of `isEmpty`

## Version 3.0.3 (2022-06-24)
 - Re-enable compiler flag `enableCompatibilityMetadataVariant=true` to support
   non-hierarchical projects. (sorry...)

## Version 3.0.2 (2022-05-14)
 - Updates `kotlin-components` submodule
     - Support new targets:
         - `iosArm32`
         - `iosSimulatorArm64`
         - `tvosSimulatorArm64`
         - `watchosx86`
         - `watchosSimulatorArm64`

## Version 3.0.1 (2022-05-08)
 - Updates `kotlin-components` submodule
     - Kotlin `1.6.10` -> `1.6.21`

## Version 3.0.0 (2022-02-24)
 - Adds `flavor` argument

## Version 2.0.0 (2022-01-14)
 - Updates `kotlin-components` submodule
     - Kotlin `1.5.31` -> `1.6.10`
 - Removes the `Platform` class and associated argument
 - Enables Kotlin 1.6's new memory model
 - Documentation improvements
 - Removes the `android` target (`-jvm` will be imported for android consumers)

## Version 1 (2021-10-31)
 - Initial Release
