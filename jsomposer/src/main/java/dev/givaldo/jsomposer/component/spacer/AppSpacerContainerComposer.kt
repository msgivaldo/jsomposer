package dev.givaldo.jsomposer.component.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.givaldo.jsomposer.common.AppParamsComposer.modifierFromParams
import dev.givaldo.jsomposer.core.AppComponentComposer

object AppSpacerContainerComposer : AppComponentComposer<AppSpacer> {

    @Composable
    override fun CreateComponent(appComponent: AppSpacer) {
        Spacer(
            modifier = Modifier.modifierFromParams(appComponent.params)
        )
    }
}