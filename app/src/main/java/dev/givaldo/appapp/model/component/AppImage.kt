package dev.givaldo.appapp.model.component

import dev.givaldo.appapp.model.common.AppParams

data class AppImage(
    var path: String,
    override val params: AppParams,
) : AppComponent(params)