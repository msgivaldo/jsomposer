package dev.givaldo.appapp.model.component.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.givaldo.appapp.core.AppComponentComposer
import dev.givaldo.appapp.model.common.AppParamsComposer.modifierFromParams

object AppSpacerContainerComposer : AppComponentComposer<AppSpacer> {

    @Composable
    override fun CreateComponent(appComponent: AppSpacer) {
        Spacer(
            modifier = Modifier.modifierFromParams(appComponent.params)
        )
    }
}