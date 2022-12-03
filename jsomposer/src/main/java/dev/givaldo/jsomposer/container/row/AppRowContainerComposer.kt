package dev.givaldo.jsomposer.container.row

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.givaldo.jsomposer.core.AppContainerComposer
import dev.givaldo.jsomposer.common.AppParamsComposer.modifierFromParams

object AppRowContainerComposer : AppContainerComposer<AppRow> {

    @Composable
    override fun CreateComponent(
        appView: AppRow,
        content: @Composable () -> Unit
    ) {
        val arrangement = when (appView.arrangement) {
            AppRow.Arrangement.START -> Arrangement.Start
            AppRow.Arrangement.END -> Arrangement.End
        }

        Row(
            horizontalArrangement = arrangement,
            modifier = Modifier.modifierFromParams(appView.params)
        ) {
            content()
        }
    }
}