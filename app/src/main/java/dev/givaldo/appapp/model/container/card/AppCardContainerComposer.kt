package dev.givaldo.appapp.model.container.card

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.givaldo.appapp.core.AppContainerComposer
import dev.givaldo.appapp.model.common.AppParamsComposer.modifierFromParams

object AppCardContainerComposer : AppContainerComposer<AppCard> {

    @Composable
    override fun CreateComponent(appView: AppCard, content: @Composable () -> Unit) {
        Card(
            shape = RoundedCornerShape(appView.radius.dp),
            modifier = Modifier.modifierFromParams(appView.params)
        ) {
            content()
        }
    }

}