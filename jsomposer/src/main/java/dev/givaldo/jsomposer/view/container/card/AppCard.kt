package dev.givaldo.jsomposer.view.container.card

import dev.givaldo.jsomposer.core.app.AppView
import dev.givaldo.jsomposer.view.common.AppParams
import dev.givaldo.jsomposer.view.container.AppContainer

data class AppCard(
    override val items: List<AppView>,
    override val params: AppParams,
    val radius: Float,
) : AppContainer(items, params)

