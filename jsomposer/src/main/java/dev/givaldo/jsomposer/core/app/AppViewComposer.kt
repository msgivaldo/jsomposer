package dev.givaldo.jsomposer.core.app

import androidx.compose.runtime.Composable
import dev.givaldo.jsomposer.view.component.button.AppButton
import dev.givaldo.jsomposer.view.component.button.AppButtonComposer
import dev.givaldo.jsomposer.view.component.image.AppImage
import dev.givaldo.jsomposer.view.component.image.AppImageContainerComposer
import dev.givaldo.jsomposer.view.component.spacer.AppSpacer
import dev.givaldo.jsomposer.view.component.spacer.AppSpacerContainerComposer
import dev.givaldo.jsomposer.view.component.text.AppText
import dev.givaldo.jsomposer.view.component.text.AppTextContainerComposer
import dev.givaldo.jsomposer.view.component.topbar.AppTopBar
import dev.givaldo.jsomposer.view.component.topbar.AppTopBarContainerComposer
import dev.givaldo.jsomposer.view.container.AppContainer
import dev.givaldo.jsomposer.view.container.card.AppCard
import dev.givaldo.jsomposer.view.container.card.AppCardContainerComposer
import dev.givaldo.jsomposer.view.container.column.AppColumn
import dev.givaldo.jsomposer.view.container.column.AppColumnContainerComposer
import dev.givaldo.jsomposer.view.container.row.AppRow
import dev.givaldo.jsomposer.view.container.row.AppRowContainerComposer

@Composable
fun ComposerAppView(appView: AppView) {

    when (appView) {
        is AppText -> AppTextContainerComposer.CreateComponent(appComponent = appView)
        is AppTopBar -> AppTopBarContainerComposer.CreateComponent(appComponent = appView)
        is AppImage -> AppImageContainerComposer.CreateComponent(appComponent = appView)
        is AppSpacer -> AppSpacerContainerComposer.CreateComponent(appComponent = appView)
        is AppContainer -> ComposerAppContainer(appContainer = appView)
        is AppButton -> AppButtonComposer.CreateComponent(appComponent = appView)
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
