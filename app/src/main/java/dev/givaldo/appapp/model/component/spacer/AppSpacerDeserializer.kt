package dev.givaldo.appapp.model.component.spacer

import dev.givaldo.appapp.core.Deserializer
import dev.givaldo.appapp.model.common.deserializeAppParams

object AppSpacerDeserializer : Deserializer<AppSpacer> {
    override val key: String = "spacer"

    override fun deserialize(value: Map<*, *>?): AppSpacer {
        return AppSpacer(params = deserializeAppParams(value))
    }
}

