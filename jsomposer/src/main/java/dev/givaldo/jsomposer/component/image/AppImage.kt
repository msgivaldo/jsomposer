package dev.givaldo.jsomposer.component.image

import dev.givaldo.jsomposer.common.AppParams
import dev.givaldo.jsomposer.core.AppComponent

data class AppImage(
    var path: String,
    override val params: AppParams,
) : AppComponent(params)

