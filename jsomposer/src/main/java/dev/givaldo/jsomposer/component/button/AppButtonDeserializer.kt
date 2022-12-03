package dev.givaldo.jsomposer.component.button

import dev.givaldo.jsomposer.core.Deserializer
import dev.givaldo.appapp.core.string
import dev.givaldo.jsomposer.common.deserializeAppParams

object AppButtonDeserializer : Deserializer<AppButton> {
    override val key: String = "button"

    override fun deserialize(value: Map<*, *>?): AppButton {
        return AppButton(
            text = value?.get("text").string,
            params = deserializeAppParams(value),
        )
    }
}