package dev.givaldo.jsomposer.component.spacer

import dev.givaldo.jsomposer.core.Deserializer
import dev.givaldo.jsomposer.common.deserializeAppParams

object AppSpacerDeserializer : Deserializer<AppSpacer> {
    override val key: String = "spacer"

    override fun deserialize(value: Map<*, *>?): AppSpacer {
        return AppSpacer(params = deserializeAppParams(value))
    }
}

