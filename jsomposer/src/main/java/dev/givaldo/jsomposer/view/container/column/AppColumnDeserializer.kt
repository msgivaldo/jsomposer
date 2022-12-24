package dev.givaldo.jsomposer.view.container.column

import dev.givaldo.jsomposer.core.Deserializer
import dev.givaldo.jsomposer.core.string
import dev.givaldo.jsomposer.view.common.deserializeAppParams
import dev.givaldo.jsomposer.view.container.AppContainerDeserializer

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