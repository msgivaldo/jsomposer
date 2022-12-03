package dev.givaldo.jsomposer.core

import androidx.compose.runtime.Composable
import dev.givaldo.jsomposer.component.button.AppButton
import dev.givaldo.jsomposer.component.button.AppButtonComposer
import dev.givaldo.jsomposer.component.image.AppImage
import dev.givaldo.jsomposer.component.image.AppImageContainerComposer
import dev.givaldo.jsomposer.component.spacer.AppSpacer
import dev.givaldo.jsomposer.component.spacer.AppSpacerContainerComposer
import dev.givaldo.jsomposer.component.text.AppText
import dev.givaldo.jsomposer.component.text.AppTextContainerComposer
import dev.givaldo.jsomposer.component.topbar.AppTopBar
import dev.givaldo.jsomposer.component.topbar.AppTopBarContainerComposer
import dev.givaldo.jsomposer.container.AppContainer
import dev.givaldo.jsomposer.container.card.AppCard
import dev.givaldo.jsomposer.container.card.AppCardContainerComposer
import dev.givaldo.jsomposer.container.column.AppColumn
import dev.givaldo.jsomposer.container.column.AppColumnContainerComposer
import dev.givaldo.jsomposer.container.row.AppRow
import dev.givaldo.jsomposer.container.row.AppRowContainerComposer


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
