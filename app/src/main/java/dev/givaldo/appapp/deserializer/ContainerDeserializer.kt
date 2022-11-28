package dev.givaldo.appapp.deserializer

import dev.givaldo.appapp.model.common.AppView
import dev.givaldo.appapp.model.container.*

fun Map<*, *>.appCard(): AppCard {
    return AppCard(
        items = appItems,
        params = appParams,
        radius = radius,
    )
}

fun Map<*, *>.appRow(): AppRow {
    return AppRow(
        items = appItems,
        params = appParams,
        arrangement = horizontalArrangement,
    )
}

fun Map<*, *>.appColumn(): AppColumn {
    return AppColumn(
        items = appItems,
        params = appParams,
        arrangement = verticaArrangement,
    )
}

val Map<*, *>.verticaArrangement: AppVerticalArrangement
    get() {
        val arrangement = this["arrangement"].string
        return try {
            AppVerticalArrangement.valueOf(arrangement)
        } catch (e: Exception) {
            AppVerticalArrangement.TOP
        }
    }

val Map<*, *>.horizontalArrangement: AppHorizontalArrangement
    get() {
        val arrangement = this["arrangement"].string
        return try {
            AppHorizontalArrangement.valueOf(arrangement)
        } catch (e: Exception) {
            AppHorizontalArrangement.START
        }
    }

val Map<*, *>.radius: Float
    get() {
        return this["radius"]?.float ?: 0f
    }

private val Map<*, *>.appItems: List<AppView>
    get() = (this["items"] as? List<*> ?: emptyList<AppView>())
        .filterNotNull()
        .map { item ->
            item.appView()
        }.flatten()

