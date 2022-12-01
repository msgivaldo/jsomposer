package dev.givaldo.appapp.model.component.image

import dev.givaldo.appapp.core.Deserializer
import dev.givaldo.appapp.core.string
import dev.givaldo.appapp.model.common.deserializeAppParams

object AppImageDeserializer : Deserializer<AppImage> {
    override val key: String = "image"

    override fun deserialize(value: Map<*, *>?): AppImage {
        return AppImage(
            params = deserializeAppParams(value),
            path = value?.get("path").string,
        )
    }
}