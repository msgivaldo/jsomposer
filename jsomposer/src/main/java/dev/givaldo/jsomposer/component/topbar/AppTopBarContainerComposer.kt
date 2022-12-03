package dev.givaldo.jsomposer.component.topbar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.givaldo.jsomposer.core.AppComponentComposer
import dev.givaldo.jsomposer.common.AppParamsComposer.modifierFromParams

object AppTopBarContainerComposer : AppComponentComposer<AppTopBar> {

    @Composable
    override fun CreateComponent(appComponent: AppTopBar) {

        val icon = when (appComponent.navIcon) {
            AppTopBar.NavIcon.BACK -> Icons.Filled.ArrowBack
            AppTopBar.NavIcon.CLOSE -> Icons.Filled.Close
        }

        TopAppBar(
            title = {
                Text(text = appComponent.title.orEmpty())
            },
            modifier = Modifier.modifierFromParams(appComponent.params),
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = icon,
                        contentDescription = appComponent.navIcon.description
                    )
                }
            }
        )
    }
}
