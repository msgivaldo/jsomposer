package dev.givaldo.appapp.model.common

import dev.givaldo.appapp.core.float
import dev.givaldo.appapp.core.string

data class AppParams(
    val paddings: AppDimens = AppDimens(),
    val width: Float = -2f,
    val height: Float = -1f,
    val background: String? = null,
)

fun deserializeAppParams(value: Map<*, *>?): AppParams {
    value ?: return AppParams()

    return AppParams(
        paddings = deserializeAppDimens(value["padding"] as? Map<*, *>),
        width = value["width"].float,
        height = value["height"].float,
        background = value["background"].string,
    )
}

