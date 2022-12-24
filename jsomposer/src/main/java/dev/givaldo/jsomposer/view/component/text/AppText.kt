package dev.givaldo.jsomposer.view.component.text

import dev.givaldo.jsomposer.core.app.AppComponent
import dev.givaldo.jsomposer.view.common.AppParams

data class AppText(
    var value: String,
    val weight: AppFontWeight = AppFontWeight.NORMAL,
    val size: Double = 16.0,
    override val params: AppParams,
) : AppComponent(params) {

    enum class AppFontWeight { NORMAL, BOLD, SEMI_BOLD }
}