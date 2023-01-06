/*
 * Copyright (c) 2021 Matthew Nelson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package io.matthewnelson.component.build.configuration

import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Holder for build configuration information
 *
 * @throws [IllegalStateException] when:
 *  - [applicationId] is empty
 *  - [versionName] is empty
 *  - [versionCode] is less than or equal to 0
 * */
class BuildConfiguration {
    @JvmField val applicationId: String
    @JvmField val versionName: String
    @JvmField val versionCode: Int
    @JvmField val isDebug: Boolean
    @JvmField val variant: String
    @JvmField val flavor: String

    @Throws(IllegalStateException::class)
    constructor(
        applicationId: String,
        versionName: String,
        versionCode: Int,
        isDebug: Boolean,
        variant: String,
        flavor: String,
    ) {
        check(applicationId.isNotEmpty()) { "applicationId cannot be empty" }
        check(versionName.isNotEmpty()) { "versionName cannot be empty" }
        check(versionCode > 0) { "versionCode must be greater than 0" }

        this.applicationId = applicationId
        this.versionName = versionName
        this.versionCode = versionCode
        this.isDebug = isDebug
        this.variant = variant
        this.flavor = flavor
    }

    @Throws(IllegalStateException::class)
    constructor(
        applicationId: String,
        versionName: String,
        versionCode: Int,
        isDebug: Boolean,
        variant: String,
    ): this(
        applicationId,
        versionName,
        versionCode,
        isDebug,
        variant,
        flavor = ""
    )

    @Throws(IllegalStateException::class)
    constructor(
        applicationId: String,
        versionName: String,
        versionCode: Int,
        flavor: String,
        isDebug: Boolean,
    ): this(
        applicationId,
        versionName,
        versionCode,
        isDebug,
        if (isDebug) "debug" else "release",
        flavor
    )

    @Throws(IllegalStateException::class)
    constructor(
        applicationId: String,
        versionName: String,
        versionCode: Int,
        isDebug: Boolean,
    ): this(
        applicationId,
        versionName,
        versionCode,
        isDebug,
        variant = if (isDebug) "debug" else "release",
        flavor = ""
    )

    operator fun component1(): String = applicationId
    operator fun component2(): String = versionName
    operator fun component3(): Int = versionCode
    operator fun component4(): Boolean = isDebug
    operator fun component5(): String = variant
    operator fun component6(): String = flavor

    override fun equals(other: Any?): Boolean {
        return  other is BuildConfiguration             &&
                other.applicationId == applicationId    &&
                other.versionName == versionName        &&
                other.versionCode == versionCode        &&
                other.isDebug == isDebug                &&
                other.variant == variant                &&
                other.flavor == flavor
    }

    override fun hashCode(): Int {
        var result = 17
        result = result * 31 + applicationId.hashCode()
        result = result * 31 + versionName.hashCode()
        result = result * 31 + versionCode.hashCode()
        result = result * 31 + isDebug.hashCode()
        result = result * 31 + variant.hashCode()
        result = result * 31 + flavor.hashCode()
        return result
    }

    override fun toString(): String {
        return  "BuildConfiguration(" +
                "applicationId=$applicationId," +
                "versionName=$versionName," +
                "versionCode=$versionCode," +
                "isDebug=$isDebug," +
                "variant=$variant," +
                "flavor=$flavor" +
                ")"
    }

    fun copy(
        applicationId: String = this.applicationId,
        versionName: String = this.versionName,
        versionCode: Int = this.versionCode,
        isDebug: Boolean = this.isDebug,
        variant: String = this.variant,
        flavor: String = this.flavor,
    ): BuildConfiguration {
        return BuildConfiguration(
            applicationId,
            versionName,
            versionCode,
            isDebug,
            variant,
            flavor,
        )
    }

    @Deprecated("Use field", ReplaceWith("applicationId"))
    fun getApplicationId(): String = applicationId
    @JvmName("isDebug")
    @Deprecated("Use field", ReplaceWith("isDebug"))
    fun getIsDebug(): Boolean = isDebug
    @Deprecated("Use field", ReplaceWith("flavor"))
    fun getFlavor(): String = flavor
    @Deprecated("Use field", ReplaceWith("variant"))
    fun getVariant(): String = variant
    @Deprecated("Use field", ReplaceWith("versionCode"))
    fun getVersionCode(): Int = versionCode
    @Deprecated("Use field", ReplaceWith("versionName"))
    fun getVersionName(): String = versionName
}
