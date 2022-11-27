package dev.givaldo.appapp.parser

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.givaldo.appapp.model.common.AppView
import dev.givaldo.appapp.model.component.AppImage
import dev.givaldo.appapp.model.component.AppSpacer
import dev.givaldo.appapp.model.component.AppText
import dev.givaldo.appapp.model.container.AppCard
import dev.givaldo.appapp.model.container.AppColumn
import dev.givaldo.appapp.model.container.AppContainer
import dev.givaldo.appapp.model.container.AppRow

@Composable
fun AppView.AppCompose() {
    when (this) {
        is AppContainer -> AppCompose()
        is AppText -> ComposeText()
        is AppImage -> ComposeImage()
        is AppSpacer -> ComposeSpacer()
        else -> error("unexpected component type")
    }
}

@Composable
private fun List<AppView>.AppCompose() {
    forEach { appView -> appView.AppCompose() }
}

@Composable
private fun AppContainer.AppCompose(
    modifier: Modifier = Modifier) {
    when (this) {
        is AppCard -> ComposeCard(modifier) {
            items.AppCompose()
        }
        is AppColumn -> ComposeColumn(modifier) {
            items.AppCompose()
        }
        is AppRow -> ComposeRow(modifier) {
            this.items.AppCompose()
        }
    }
}