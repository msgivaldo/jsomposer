package dev.givaldo.appapp.parser

import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.givaldo.appapp.model.common.AppParams

fun Modifier.appModifier(appParams: AppParams?) = this
    .composeWidth(appParams)
    .composeHeight(appParams)
    .composePadding(appParams)

fun Modifier.composeWidth(
    appParams: AppParams?
): Modifier {
    appParams ?: return this.wrapContentWidth()
    if (appParams.width == -1f) return this.wrapContentWidth()
    if (appParams.width == -2f) return this.fillMaxWidth()
    return this.width(appParams.width.dp)
}

fun Modifier.composeHeight(
    appParams: AppParams?
): Modifier {
    appParams ?: return this.wrapContentHeight()
    if (appParams.height == -1f) return this.wrapContentHeight()
    if (appParams.height == -2f) return this.fillMaxHeight()
    return this.height(appParams.height.dp)
}

fun Modifier.composePadding(
    appParams: AppParams?
): Modifier {
    appParams ?: return this.padding(PaddingValues(0.dp))
    val values = PaddingValues(
        start = appParams.paddings.start.dp,
        end = appParams.paddings.end.dp,
        top = appParams.paddings.top.dp,
        bottom = appParams.paddings.bottom.dp
    )
    return this.padding(values)
}