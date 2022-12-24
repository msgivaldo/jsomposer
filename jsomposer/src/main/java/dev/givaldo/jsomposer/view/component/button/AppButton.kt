package dev.givaldo.jsomposer.view.component.button

import dev.givaldo.jsomposer.core.app.AppComponent
import dev.givaldo.jsomposer.view.common.AppParams

data class AppButton(
    val text: String,
    override val params: AppParams,
) : AppComponent(params)