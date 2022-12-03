package dev.givaldo.jsomposer.component.text

import dev.givaldo.jsomposer.common.AppParams
import dev.givaldo.jsomposer.core.AppComponent

data class AppText(
    var value: String,
    val weight: AppFontWeight = AppFontWeight.NORMAL,
    val size: Double = 16.0,
    override val params: AppParams,
) : AppComponent(params) {

    enum class AppFontWeight { NORMAL, BOLD, SEMI_BOLD }
}