package dev.givaldo.appapp.model.component

import dev.givaldo.appapp.model.common.AppParams
import dev.givaldo.appapp.model.common.AppView

abstract class AppComponent(
    open val params: AppParams
): AppView()
