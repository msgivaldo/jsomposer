package dev.givaldo.jsomposer.container

import dev.givaldo.jsomposer.core.AppView
import dev.givaldo.appapp.core.AppViewDeserializer
import dev.givaldo.jsomposer.common.AppParams

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