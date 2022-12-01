package dev.givaldo.appapp.core

import dev.givaldo.appapp.model.common.AppParams

abstract class AppComponent(
    open val params: AppParams
) : AppView