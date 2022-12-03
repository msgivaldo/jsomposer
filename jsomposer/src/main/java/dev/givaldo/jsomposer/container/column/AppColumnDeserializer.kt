package dev.givaldo.jsomposer.container.column

import dev.givaldo.jsomposer.core.Deserializer
import dev.givaldo.appapp.core.string
import dev.givaldo.jsomposer.common.deserializeAppParams
import dev.givaldo.jsomposer.container.AppContainerDeserializer

object AppColumnDeserializer : Deserializer<AppColumn> {
    override val key: String = "column"

    override fun deserialize(value: Map<*, *>?): AppColumn {
        return AppColumn(
            items = AppContainerDeserializer.deserialize(value),
            params = deserializeAppParams(value),
            arrangement = value.arrangement,
        )
    }

    private val Map<*, *>?.arrangement: AppColumn.Arrangement
        get() {
            val arrangement = this?.get("arrangement").string
            return try {
                AppColumn.Arrangement.valueOf(arrangement)
            } catch (e: Exception) {
                AppColumn.Arrangement.TOP
            }
        }
}