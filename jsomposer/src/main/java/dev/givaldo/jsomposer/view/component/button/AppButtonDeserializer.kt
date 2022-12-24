package dev.givaldo.jsomposer.view.component.button

import dev.givaldo.jsomposer.core.Deserializer
import dev.givaldo.jsomposer.core.string
import dev.givaldo.jsomposer.view.common.deserializeAppParams

object AppButtonDeserializer : Deserializer<AppButton> {
    override val key: String = "button"

    override fun deserialize(value: Map<*, *>?): AppButton {
        return AppButton(
            text = value?.get("text").string,
            params = deserializeAppParams(value),
        )
    }
}