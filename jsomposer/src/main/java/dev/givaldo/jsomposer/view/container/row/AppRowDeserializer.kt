package dev.givaldo.jsomposer.view.container.row

import dev.givaldo.jsomposer.core.Deserializer
import dev.givaldo.jsomposer.core.string
import dev.givaldo.jsomposer.view.common.deserializeAppParams
import dev.givaldo.jsomposer.view.container.AppContainerDeserializer

object AppRowDeserializer : Deserializer<AppRow> {
    override val key: String = "row"

    override fun deserialize(value: Map<*, *>?): AppRow {
        return AppRow(
            items = AppContainerDeserializer.deserialize(value),
            params = deserializeAppParams(value),
            arrangement = value.arrangement,
        )
    }

    private val Map<*, *>?.arrangement: AppRow.Arrangement
        get() {
            val arrangement = this?.get("arrangement").string
            return try {
                AppRow.Arrangement.valueOf(arrangement)
            } catch (e: Exception) {
                AppRow.Arrangement.START
            }
        }
}