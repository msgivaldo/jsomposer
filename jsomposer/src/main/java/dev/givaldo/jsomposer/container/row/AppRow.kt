package dev.givaldo.jsomposer.container.row

import dev.givaldo.jsomposer.common.AppParams
import dev.givaldo.jsomposer.container.AppContainer
import dev.givaldo.jsomposer.core.AppView

data class AppRow(
    override val items: List<AppView>,
    override val params: AppParams,
    val arrangement: Arrangement,
) : AppContainer(items, params) {

    enum class Arrangement {
        START, END
    }
}

