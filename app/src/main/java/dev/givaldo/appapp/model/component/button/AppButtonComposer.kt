package dev.givaldo.appapp.model.component.button

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.givaldo.appapp.core.AppComponentComposer
import dev.givaldo.appapp.model.common.AppParamsComposer.color
import dev.givaldo.appapp.model.common.AppParamsComposer.modifierFromParams

object AppButtonComposer : AppComponentComposer<AppButton> {

    @Composable
    override fun CreateComponent(appComponent: AppButton) {
        val default = ButtonDefaults.buttonColors().backgroundColor(enabled = true).value
        val color = appComponent.params.background?.color ?: default

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = color),
            onClick = { },
            modifier = Modifier.modifierFromParams(appComponent.params),
        ) {
            Text(text = appComponent.text)
        }
    }
}