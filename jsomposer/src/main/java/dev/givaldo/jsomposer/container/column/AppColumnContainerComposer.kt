package dev.givaldo.jsomposer.container.column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.givaldo.jsomposer.core.AppContainerComposer
import dev.givaldo.jsomposer.common.AppParamsComposer.modifierFromParams

object AppColumnContainerComposer : AppContainerComposer<AppColumn> {

    @Composable
    override fun CreateComponent(
        appView: AppColumn,
        content: @Composable () -> Unit
    ) {

        val arrangement = when (appView.arrangement) {
            AppColumn.Arrangement.TOP -> Arrangement.Top
            AppColumn.Arrangement.BOTTOM -> Arrangement.Bottom
        }

        Column(
            verticalArrangement = arrangement,
            modifier = Modifier.modifierFromParams(appView.params)
        ) {
            content()
        }
    }
}