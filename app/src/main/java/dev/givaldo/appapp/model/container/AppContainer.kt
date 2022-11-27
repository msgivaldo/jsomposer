package dev.givaldo.appapp.model.container

import dev.givaldo.appapp.model.common.AppParams
import dev.givaldo.appapp.model.common.AppView

abstract class AppContainer(
    open val items: List<AppView>,
    open val params: AppParams?,
): AppView()

data class AppCard(
    override val items: List<AppView>,
    override val params: AppParams?,
) : AppContainer(items, params)

data class AppRow(
    override val items: List<AppView>,
    override val params: AppParams?,
) : AppContainer(items, params)

data class AppColumn(
    override val items: List<AppView>,
    override val params: AppParams?,
) : AppContainer(items, params)