package dev.givaldo.jsomposer.view.component.topbar

import dev.givaldo.jsomposer.core.app.AppComponent
import dev.givaldo.jsomposer.view.common.AppParams

data class AppTopBar(
    override val params: AppParams,
    val navIcon: NavIcon,
    val title: String?,
) : AppComponent(params) {

    enum class NavIcon(val description: String) {
        BACK("back"), CLOSE("close")
    }
}

