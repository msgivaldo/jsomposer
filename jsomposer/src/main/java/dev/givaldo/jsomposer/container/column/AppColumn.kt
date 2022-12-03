package dev.givaldo.jsomposer.container.column

import dev.givaldo.jsomposer.common.AppParams
import dev.givaldo.jsomposer.container.AppContainer
import dev.givaldo.jsomposer.core.AppView

data class AppColumn(
    override val items: List<AppView>,
    override val params: AppParams,
    val arrangement: Arrangement,
) : AppContainer(items, params) {

    enum class Arrangement {
        TOP, BOTTOM
    }
}

