package dev.givaldo.appapp.model.component

data class AppImage(
    var path: String,
    override val params: AppComponentParams,
) : AppComponent(params)