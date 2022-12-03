package dev.givaldo.jsomposer.component.topbar

import dev.givaldo.jsomposer.common.AppParams
import dev.givaldo.jsomposer.core.AppComponent

data class AppTopBar(
    override val params: AppParams,
    val navIcon: NavIcon,
    val title: String?,
) : AppComponent(params) {

    enum class NavIcon(val description: String) {
        BACK("back"), CLOSE("close")
    }
}

