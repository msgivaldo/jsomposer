@file:Suppress("UNCHECKED_CAST")

package dev.givaldo.appapp.deserializer

import dev.givaldo.appapp.model.common.AppView
import dev.givaldo.appapp.model.component.*

fun Any.appView(): List<AppView> {
    val map = this as Map<*, Map<*, *>>
    return map.appView()
}

private fun Map<*, Map<*, *>>.appView(): List<AppView> {
    return map {
        when (it.key) {
            "appbar" -> it.value.appTopBar()
            "card" -> it.value.appCard()
            "column" -> it.value.appColumn()
            "row" -> it.value.appRow()
            "spacer" -> it.value.appSpacer()
            "text" -> it.value.appText()
            "image" -> it.value.appImage()
            else -> error("Unexpected view type: ${it.key}")
        }
    }
}


fun Map<*, *>.appTopBar(): AppTopBar {
    return AppTopBar(
        params = appParams,
        navIcon = navIcon,
        title = navTitle
    )
}

val Map<*, *>.navIcon: AppTopBar.NavIcon
    get() {
        return try {
            AppTopBar.NavIcon.valueOf(this["nav_icon"].string)
        } catch (exception: Exception) {
            AppTopBar.NavIcon.BACK
        }
    }

val Map<*, *>.navTitle: String?
    get() = this["title"]?.string


private fun Map<*, *>.appText(): AppText {
    return AppText(
        value = this["value"] as String,
        size = this["size"] as Double,
        weight = AppText.AppFontWeight.valueOf(this["weight"] as String),
        params = appParams
    )
}

private fun Map<*, *>.appImage(): AppImage {
    return AppImage(
        path = this["path"] as String,
        params = appParams
    )
}

private fun Map<*, *>.appSpacer(): AppSpacer {
    return AppSpacer(params = appParams)
}