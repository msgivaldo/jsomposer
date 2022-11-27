package dev.givaldo.appapp.model.common

abstract class AppView

data class AppParams(
    val paddings: AppDimens,
    val width: Float,
    val height: Float,
    val background: String?,
)

data class AppDimens(
    val start: Double,
    val top: Double,
    val end: Double,
    val bottom: Double
) {
    constructor(value: Double = 0.0) : this(value, value, value, value)
}