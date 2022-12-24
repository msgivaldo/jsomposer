package dev.givaldo.jsomposer.view.component.image

import dev.givaldo.jsomposer.core.app.AppComponent
import dev.givaldo.jsomposer.view.common.AppParams

data class AppImage(
    var path: String,
    override val params: AppParams,
) : AppComponent(params)

