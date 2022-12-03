package dev.givaldo.appapp.model.component.button

import dev.givaldo.appapp.core.Deserializer
import dev.givaldo.appapp.core.string
import dev.givaldo.appapp.model.common.deserializeAppParams

object AppButtonDeserializer : Deserializer<AppButton> {
    override val key: String = "button"

    override fun deserialize(value: Map<*, *>?): AppButton {
        return AppButton(
            text = value?.get("text").string,
            params = deserializeAppParams(value),
        )
    }
}