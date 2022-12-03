package dev.givaldo.jsomposer.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object AppParamsComposer {

    fun Modifier.modifierFromParams(params: AppParams): Modifier {
        return this
            .setWidth(params)
            .setHeight(params)
            .setPadding(params)
            .setBackground(params)
    }

    private fun Modifier.setWidth(params: AppParams): Modifier {
        if (params.width == -1f) return this.wrapContentWidth()
        if (params.width == -2f) return this.fillMaxWidth()
        return this.width(params.width.dp)
    }

    private fun Modifier.setHeight(params: AppParams): Modifier {
        if (params.height == -1f) return this.wrapContentHeight()
        if (params.height == -2f) return this.fillMaxHeight()
        return this.height(params.height.dp)
    }

    private fun Modifier.setPadding(params: AppParams): Modifier {
        val values = PaddingValues(
            start = params.paddings.start.dp,
            end = params.paddings.end.dp,
            top = params.paddings.top.dp,
            bottom = params.paddings.bottom.dp
        )
        return this.padding(values)
    }

    private fun Modifier.setBackground(params: AppParams): Modifier {
        val color = params.background?.color ?: return this
        return this.background(color = color)
    }

    val String.color: Color?
        get() = try {
            Color(android.graphics.Color.parseColor(this))
        } catch (exception: Exception) {
            null
        }
}