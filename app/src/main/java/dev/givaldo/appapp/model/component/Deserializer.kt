package dev.givaldo.appapp.model.component

import Container
import ContainerParams
import dev.givaldo.appapp.model.component.*

fun <T> T.component(): List<View> {
    if (this !is Map<*, *>) error("dimens is not a dev.givaldo.appapp.model.component.Component. $this")

    val views = mutableListOf<View>()

    this.forEach {
        when (it.key) {
            "container" -> {
                val container = it.value.container()
                views.add(container)
            }

            "spacer" -> views.add(it.value.spacer())
            "text" -> views.add(it.value.text())
            "image" -> views.add(it.value.image())
            else -> {}
        }
    }
    return views
}

fun <T> T.container(): Container {
    if (this !is Map<*, *>) error("dimens is not a Component. $this")

    val params = this["params"]?.containerParams()
    val items = mutableListOf<View>()
    (this["items"] as List<*>).forEach { item ->
        items.addAll(item.component())
    }
    return Container(items, params)
}

private fun <T> T.text(): AppText {
    this as? Map<*, *> ?: error("dimens is not a text. $this")

    return AppText(
        value = this["value"] as String,
        size = this["size"] as Double,
        weight = AppFontWeight.valueOf(this["weight"] as String),
        params = params()
    )
}

private fun <T> T.image(): AppImage {
    if (this !is Map<*, *>) error("dimens is not an image. $this")

    return AppImage(
        path = this["path"] as String,
        params = params()
    )
}

private fun <T> T.spacer(): AppSpacer {
    if (this !is Map<*, *>) error("dimens is not a spacer. $this")

    return AppSpacer(
        params = params()
    )
}

private fun <T> T.params(): AppComponentParams {
    if (this !is Map<*, *>) error("dimens is not a dev.givaldo.appapp.component.Params. $this")
    return AppComponentParams(
        paddings = this["padding"]?.dimens(),
        margins = this["margins"]?.dimens(),
        width = this["width"].anyToFloat(),
        height = this["height"].anyToFloat(),
        background = this["background"].anyToInt()
    )
}


private fun <T> T.containerParams(): ContainerParams {
    if (this !is Map<*, *>) error("dimens is not a dev.givaldo.appapp.component.Params. $this")
    return ContainerParams(
        paddings = this["padding"]?.dimens(),
        margins = this["margins"]?.dimens(),
        width = this["width"].anyToFloat(),
        height = this["height"].anyToFloat(),
        background = this["background"] as? Int,
        type = ContainerType.valueOf(this["type"] as String)
    )
}

private fun Any?.anyToFloat(): Float {
    return this?.toString()?.toFloat() ?: -1f
}

private fun Any?.anyToInt(): Int {
    return this?.toString()?.toInt() ?: -0
}

private fun <T> T.dimens(): AppDimens {
    if (this !is Map<*, *>) error("dimens is not a HashMap. $this")
    return AppDimens(
        start = this["start"] as Double,
        end = this["end"] as Double,
        top = this["top"] as Double,
        bottom = this["bottom"] as Double
    )
}

