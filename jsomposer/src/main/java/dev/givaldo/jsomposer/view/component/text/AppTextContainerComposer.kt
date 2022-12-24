package dev.givaldo.jsomposer.view.component.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.givaldo.jsomposer.core.AppComponentComposer
import dev.givaldo.jsomposer.view.common.AppParamsComposer.modifierFromParams

object AppTextContainerComposer : AppComponentComposer<AppText> {

    @Composable
    override fun CreateComponent(appComponent: AppText) {

        val weight = when (appComponent.weight) {
            AppText.AppFontWeight.BOLD -> FontWeight.Bold
            AppText.AppFontWeight.NORMAL -> FontWeight.Normal
            AppText.AppFontWeight.SEMI_BOLD -> FontWeight.SemiBold
        }

        Text(
            text = appComponent.value,
            fontSize = appComponent.size.sp,
            modifier = Modifier.modifierFromParams(appComponent.params),
            fontWeight = weight,
        )
    }
}