package dev.givaldo.appapp.deserializer

import dev.givaldo.appapp.model.common.AppDimens
import dev.givaldo.appapp.model.common.AppParams

val Map<*, *>?.paddings: AppDimens
    get() = (this?.get("padding") as? Map<*, *>).dimens

val Map<*, *>?.width: Float
    get() = this?.get("width").float

val Map<*, *>?.height: Float
    get() = this?.get("height").float

val Map<*, *>?.background: String
    get() = this?.get("background").string

val Map<*, *>?.dimens: AppDimens
    get() {
        this ?: return AppDimens(0.0)
        return AppDimens(
            start = this["start"].double,
            end = this["end"].double,
            top = this["top"].double,
            bottom = this["bottom"].double
        )
    }

val Any?.string: String
    get() = this?.toString().orEmpty()

val Any?.float: Float
    get() = this?.string?.toFloat() ?: -1f

val Any?.double: Double
    get() = this?.string?.toDouble() ?: -1.0

val Map<*, *>?.appParams: AppParams
    get() = AppParams(
        paddings = paddings,
        width = width,
        height = height,
        background = background
    )



