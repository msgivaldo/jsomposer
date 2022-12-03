package dev.givaldo.jsomposer.common

import dev.givaldo.appapp.core.double

data class AppDimens(
    val start: Double,
    val top: Double,
    val end: Double,
    val bottom: Double
) {
    constructor(value: Double = 0.0) : this(value, value, value, value)
}

fun deserializeAppDimens(value: Map<*, *>?): AppDimens {
    value ?: return AppDimens(0.0)
    return AppDimens(
        start = value["start"].double,
        end = value["end"].double,
        top = value["top"].double,
        bottom = value["bottom"].double
    )
}