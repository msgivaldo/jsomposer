package dev.givaldo.jsomposer.view.container

import dev.givaldo.jsomposer.core.app.AppView
import dev.givaldo.jsomposer.core.app.AppViewDeserializer
import dev.givaldo.jsomposer.view.common.AppParams

abstract class AppContainer(
    open val items: List<AppView>,
    open val params: AppParams
) : AppView

object AppContainerDeserializer {

    fun deserialize(
        value: Map<*, *>?,
    ): List<AppView> {
        return (value?.get("items") as? List<*> ?: emptyList<AppView>())
            .filterNotNull()
            .map { item ->
                AppViewDeserializer.deserializeMap(item as Map<*, *>)
            }.flatten()
    }
}