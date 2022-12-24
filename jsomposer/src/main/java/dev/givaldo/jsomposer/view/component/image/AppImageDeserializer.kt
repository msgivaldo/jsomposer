package dev.givaldo.jsomposer.view.component.image

import dev.givaldo.jsomposer.core.Deserializer
import dev.givaldo.jsomposer.core.string
import dev.givaldo.jsomposer.view.common.deserializeAppParams

object AppImageDeserializer : Deserializer<AppImage> {
    override val key: String = "image"

    override fun deserialize(value: Map<*, *>?): AppImage {
        return AppImage(
            params = deserializeAppParams(value),
            path = value?.get("path").string,
        )
    }
}