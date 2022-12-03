package dev.givaldo.jsomposer.container.card

import dev.givaldo.jsomposer.core.Deserializer
import dev.givaldo.appapp.core.float
import dev.givaldo.jsomposer.common.deserializeAppParams
import dev.givaldo.jsomposer.container.AppContainerDeserializer

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