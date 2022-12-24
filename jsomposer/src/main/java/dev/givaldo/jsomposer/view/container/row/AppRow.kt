package dev.givaldo.jsomposer.view.container.row

import dev.givaldo.jsomposer.core.app.AppView
import dev.givaldo.jsomposer.view.common.AppParams
import dev.givaldo.jsomposer.view.container.AppContainer

data class AppRow(
    override val items: List<AppView>,
    override val params: AppParams,
    val arrangement: Arrangement,
) : AppContainer(items, params) {

    enum class Arrangement {
        START, END
    }
}

