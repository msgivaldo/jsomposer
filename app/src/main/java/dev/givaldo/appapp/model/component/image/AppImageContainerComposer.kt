package dev.givaldo.appapp.model.component.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import dev.givaldo.appapp.core.AppComponentComposer
import dev.givaldo.appapp.model.common.AppParamsComposer.modifierFromParams

object AppImageContainerComposer : AppComponentComposer<AppImage> {

    @Composable
    override fun CreateComponent(appComponent: AppImage) {
        AsyncImage(
            contentScale = ContentScale.Crop,
            model = appComponent.path,
            contentDescription = null,
            modifier = Modifier.modifierFromParams(appComponent.params)
        )
    }
}
