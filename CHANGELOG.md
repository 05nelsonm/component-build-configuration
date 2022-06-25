# CHANGELOG

## Version 3.0.2 (2022-06-24)
 - Re-enable compiler flag `enableCompatibilityMetadataVariant=true` to support
   non-hierarchical projects. (sorry...)

## Version 3.0.2 (2022-05-14)
 - Updates Kotlin-Components
     - Support new targets:
         - `iosArm32`
         - `iosSimulatorArm64`
         - `tvosSimulatorArm64`
         - `watchosx86`
         - `watchosSimulatorArm64`

## Version 3.0.1 (2022-05-08)
 - Bumps Kotlin `1.6.10` -> `1.6.21`

## Version 3.0.0 (2022-02-24)
 - Bumps dependencies
 - Adds `flavor` argument

## Version 2.0.0 (2022-01-14)
 - Removes the `Platform` class and associated argument
 - Bumps dependencies
 - Enables Kotlin 1.6's new memory model
 - Documentation updates
 - Removes the `android` target (`-jvm` will be imported for android consumers)

## Version 1 (2021-10-31)
 - Initial Release
