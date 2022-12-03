package dev.givaldo.appapp.core

import dev.givaldo.appapp.model.component.button.AppButtonDeserializer
import dev.givaldo.appapp.model.component.image.AppImageDeserializer
import dev.givaldo.appapp.model.component.spacer.AppSpacerDeserializer
import dev.givaldo.appapp.model.component.text.AppTextDeserializer
import dev.givaldo.appapp.model.component.topbar.AppTopBarDeserializer
import dev.givaldo.appapp.model.container.card.AppCardDeserializer
import dev.givaldo.appapp.model.container.column.AppColumnDeserializer
import dev.givaldo.appapp.model.container.row.AppRowDeserializer

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