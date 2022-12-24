package dev.givaldo.jsomposer.view.component.spacer

import dev.givaldo.jsomposer.core.Deserializer
import dev.givaldo.jsomposer.view.common.deserializeAppParams

object AppSpacerDeserializer : Deserializer<AppSpacer> {
    override val key: String = "spacer"

    override fun deserialize(value: Map<*, *>?): AppSpacer {
        return AppSpacer(params = deserializeAppParams(value))
    }
}

