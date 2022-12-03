package dev.givaldo.jsomposer.component.button

import dev.givaldo.jsomposer.core.AppComponent
import dev.givaldo.jsomposer.common.AppParams

data class AppButton(
    val text: String,
    override val params: AppParams,
) : AppComponent(params)