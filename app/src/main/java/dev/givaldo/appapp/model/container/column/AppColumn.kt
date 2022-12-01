package dev.givaldo.appapp.model.container.column

import dev.givaldo.appapp.core.AppView
import dev.givaldo.appapp.model.common.AppParams
import dev.givaldo.appapp.model.container.AppContainer

data class AppColumn(
    override val items: List<AppView>,
    override val params: AppParams,
    val arrangement: Arrangement,
) : AppContainer(items, params) {

    enum class Arrangement {
        TOP, BOTTOM
    }
}

