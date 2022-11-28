package dev.givaldo.appapp.model.component

import dev.givaldo.appapp.model.common.AppParams

data class AppTopBar(
    override val params: AppParams,
    val navIcon: NavIcon,
    val title: String?,
) : AppComponent(params) {

    enum class NavIcon(val description: String) {
        BACK("back"), CLOSE("close")
    }
}