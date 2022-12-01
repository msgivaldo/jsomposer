package dev.givaldo.appapp.core

import androidx.compose.runtime.Composable
import dev.givaldo.appapp.model.component.image.AppImage
import dev.givaldo.appapp.model.component.image.AppImageContainerComposer
import dev.givaldo.appapp.model.component.spacer.AppSpacer
import dev.givaldo.appapp.model.component.spacer.AppSpacerContainerComposer
import dev.givaldo.appapp.model.component.text.AppText
import dev.givaldo.appapp.model.component.text.AppTextContainerComposer
import dev.givaldo.appapp.model.component.topbar.AppTopBar
import dev.givaldo.appapp.model.component.topbar.AppTopBarContainerComposer
import dev.givaldo.appapp.model.container.AppContainer
import dev.givaldo.appapp.model.container.card.AppCard
import dev.givaldo.appapp.model.container.card.AppCardContainerComposer
import dev.givaldo.appapp.model.container.column.AppColumn
import dev.givaldo.appapp.model.container.column.AppColumnContainerComposer
import dev.givaldo.appapp.model.container.row.AppRow
import dev.givaldo.appapp.model.container.row.AppRowContainerComposer


@Composable
fun ComposerAppView(appView: AppView) {

    when (appView) {
        is AppText -> AppTextContainerComposer.CreateComponent(appComponent = appView)
        is AppTopBar -> AppTopBarContainerComposer.CreateComponent(appComponent = appView)
        is AppImage -> AppImageContainerComposer.CreateComponent(appComponent = appView)
        is AppSpacer -> AppSpacerContainerComposer.CreateComponent(appComponent = appView)
        is AppContainer -> ComposerAppContainer(appContainer = appView)
    }
}

@Composable
fun ComposerAppContainer(appContainer: AppContainer) {
    when (appContainer) {
        is AppCard -> AppCardContainerComposer.CreateComponent(appContainer) {
            ComposerAppView(appView = appContainer.items)
        }
        is AppColumn -> AppColumnContainerComposer.CreateComponent(appContainer) {
            ComposerAppView(appView = appContainer.items)
        }
        is AppRow -> AppRowContainerComposer.CreateComponent(appContainer) {
            ComposerAppView(appView = appContainer.items)
        }
    }
}

@Composable
fun ComposerAppView(appView: List<AppView>) {
    appView.forEach { ComposerAppView(appView = it) }
}
