package dev.givaldo.jsomposer.core.app

import dev.givaldo.jsomposer.view.component.button.AppButtonDeserializer
import dev.givaldo.jsomposer.view.component.image.AppImageDeserializer
import dev.givaldo.jsomposer.view.component.spacer.AppSpacerDeserializer
import dev.givaldo.jsomposer.view.component.text.AppTextDeserializer
import dev.givaldo.jsomposer.view.component.topbar.AppTopBarDeserializer
import dev.givaldo.jsomposer.view.container.card.AppCardDeserializer
import dev.givaldo.jsomposer.view.container.column.AppColumnDeserializer
import dev.givaldo.jsomposer.view.container.row.AppRowDeserializer

object AppViewDeserializer {

    private val deserializedAppViewList =
        listOf(
            AppImageDeserializer,
            AppSpacerDeserializer,
            AppTextDeserializer,
            AppTopBarDeserializer,
            AppCardDeserializer,
            AppColumnDeserializer,
            AppRowDeserializer,
            AppButtonDeserializer,
        )

    fun deserializeMap(value: Map<*, *>?): List<AppView> {
        value ?: return emptyList()

        return value.map { map ->
            deserializedAppViewList.first {
                map.key == it.key
            }.deserialize(map.value as Map<*, *>)
        }
    }
}