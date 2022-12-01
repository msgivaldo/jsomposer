package dev.givaldo.appapp.model.container.card

import dev.givaldo.appapp.core.AppView
import dev.givaldo.appapp.model.common.AppParams
import dev.givaldo.appapp.model.container.AppContainer

data class AppCard(
    override val items: List<AppView>,
    override val params: AppParams,
    val radius: Float,
) : AppContainer(items, params)

