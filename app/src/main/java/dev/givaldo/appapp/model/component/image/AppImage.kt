package dev.givaldo.appapp.model.component.image

import dev.givaldo.appapp.core.AppComponent
import dev.givaldo.appapp.model.common.AppParams

data class AppImage(
    var path: String,
    override val params: AppParams,
) : AppComponent(params)

