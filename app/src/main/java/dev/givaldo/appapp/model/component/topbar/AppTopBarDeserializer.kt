package dev.givaldo.appapp.model.component.topbar

import dev.givaldo.appapp.core.Deserializer
import dev.givaldo.appapp.core.string
import dev.givaldo.appapp.model.common.deserializeAppParams

object AppTopBarDeserializer : Deserializer<AppTopBar> {
    override val key: String = "appbar"

    override fun deserialize(value: Map<*, *>?): AppTopBar {
        return AppTopBar(
            params = deserializeAppParams(value),
            navIcon = value.navIcon,
            title = value?.get("title")?.string
        )
    }

    private val Map<*, *>?.navIcon: AppTopBar.NavIcon
        get() {
            val icon = this?.get("nav_icon").string

            return try {
                AppTopBar.NavIcon.valueOf(icon)
            } catch (exception: Exception) {
                AppTopBar.NavIcon.BACK
            }
        }
}