package dev.givaldo.jsomposer.view.component.text

import dev.givaldo.jsomposer.core.Deserializer
import dev.givaldo.jsomposer.core.double
import dev.givaldo.jsomposer.core.string
import dev.givaldo.jsomposer.view.common.deserializeAppParams

object AppTextDeserializer : Deserializer<AppText> {
    override val key: String = "text"

    override fun deserialize(value: Map<*, *>?): AppText {
        val weight = value?.get("weight")?.string?.let {
            AppText.AppFontWeight.valueOf(it)
        } ?: AppText.AppFontWeight.NORMAL

        return AppText(
            value = value?.get("value").string,
            size = value?.get("size").double,
            weight = weight,
            params = deserializeAppParams(value)
        )
    }
}