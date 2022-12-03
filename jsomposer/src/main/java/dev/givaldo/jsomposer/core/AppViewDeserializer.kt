package dev.givaldo.appapp.core


import dev.givaldo.jsomposer.component.button.AppButtonDeserializer
import dev.givaldo.jsomposer.component.image.AppImageDeserializer
import dev.givaldo.jsomposer.component.spacer.AppSpacerDeserializer
import dev.givaldo.jsomposer.component.text.AppTextDeserializer
import dev.givaldo.jsomposer.component.topbar.AppTopBarDeserializer
import dev.givaldo.jsomposer.container.card.AppCardDeserializer
import dev.givaldo.jsomposer.container.column.AppColumnDeserializer
import dev.givaldo.jsomposer.container.row.AppRowDeserializer
import dev.givaldo.jsomposer.core.AppView

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