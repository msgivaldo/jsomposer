package dev.givaldo.appapp.model.component.button

import dev.givaldo.appapp.core.AppComponent
import dev.givaldo.appapp.model.common.AppParams

data class AppButton(
    val text: String,
    override val params: AppParams,
) : AppComponent(params)