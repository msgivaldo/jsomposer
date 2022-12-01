package dev.givaldo.appapp.model.container.card

import dev.givaldo.appapp.core.Deserializer
import dev.givaldo.appapp.core.float
import dev.givaldo.appapp.model.common.deserializeAppParams
import dev.givaldo.appapp.model.container.AppContainerDeserializer

object AppCardDeserializer : Deserializer<AppCard> {

    override val key: String = "card"

    override fun deserialize(value: Map<*, *>?): AppCard {
        return AppCard(
            items = AppContainerDeserializer.deserialize(value),
            params = deserializeAppParams(value),
            radius = value?.get("radius")?.float ?: 0f,
        )
    }
}