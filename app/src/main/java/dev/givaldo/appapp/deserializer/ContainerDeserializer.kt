package dev.givaldo.appapp.deserializer

import dev.givaldo.appapp.model.common.AppView
import dev.givaldo.appapp.model.container.*

fun Map<*, *>.appCard(): AppCard {
    return AppCard(items = appItems, params = appParams)
}

fun Map<*, *>.appRow(): AppRow {
    return AppRow(items = appItems, params = appParams)
}
fun Map<*, *>.appColumn(): AppColumn {
    return AppColumn(items = appItems, params = appParams)
}

private val Map<*, *>.appItems: List<AppView>
    get() = (this["items"] as List<*>)
        .filterNotNull()
        .map { item ->
            item.appView()
        }.flatten()

