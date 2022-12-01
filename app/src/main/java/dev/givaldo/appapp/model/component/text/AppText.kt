package dev.givaldo.appapp.model.component.text

import dev.givaldo.appapp.core.AppComponent
import dev.givaldo.appapp.model.common.AppParams

data class AppText(
    var value: String,
    val weight: AppFontWeight = AppFontWeight.NORMAL,
    val size: Double = 16.0,
    override val params: AppParams,
) : AppComponent(params) {

    enum class AppFontWeight { NORMAL, BOLD, SEMI_BOLD }
}