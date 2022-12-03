package dev.givaldo.jsomposer.container.card

import dev.givaldo.jsomposer.common.AppParams
import dev.givaldo.jsomposer.container.AppContainer
import dev.givaldo.jsomposer.core.AppView

data class AppCard(
    override val items: List<AppView>,
    override val params: AppParams,
    val radius: Float,
) : AppContainer(items, params)

