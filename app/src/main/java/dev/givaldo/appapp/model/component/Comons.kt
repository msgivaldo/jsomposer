package dev.givaldo.appapp.model.component

abstract class View

abstract class Params(
    open val paddings: AppDimens,
    open val margins: AppDimens,
    open val width: Float,//match_parent
    open val height: Float,//match_parent
)

data class AppDimens(val start: Double, val top: Double, val end: Double, val bottom: Double) {
    constructor(value: Double = 0.0) : this(value, value, value, value)
}