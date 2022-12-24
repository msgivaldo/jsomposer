package dev.givaldo.jsomposer.view.component.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.givaldo.jsomposer.core.AppComponentComposer
import dev.givaldo.jsomposer.view.common.AppParamsComposer.modifierFromParams

object AppSpacerContainerComposer : AppComponentComposer<AppSpacer> {

    @Composable
    override fun CreateComponent(appComponent: AppSpacer) {
        Spacer(
            modifier = Modifier.modifierFromParams(appComponent.params)
        )
    }
}