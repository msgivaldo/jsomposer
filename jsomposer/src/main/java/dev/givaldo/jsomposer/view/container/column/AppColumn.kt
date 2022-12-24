package dev.givaldo.jsomposer.view.container.column

import dev.givaldo.jsomposer.core.app.AppView
import dev.givaldo.jsomposer.view.common.AppParams
import dev.givaldo.jsomposer.view.container.AppContainer

data class AppColumn(
    override val items: List<AppView>,
    override val params: AppParams,
    val arrangement: Arrangement,
) : AppContainer(items, params) {

    enum class Arrangement {
        TOP, BOTTOM
    }
}

