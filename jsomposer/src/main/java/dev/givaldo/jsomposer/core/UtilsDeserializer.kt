package dev.givaldo.jsomposer.core

val Any?.string: String
    get() = this?.toString().orEmpty()

val Any?.float: Float
    get() = this?.string?.toFloat() ?: -1f

val Any?.double: Double
    get() = this?.string?.toDouble() ?: -1.0