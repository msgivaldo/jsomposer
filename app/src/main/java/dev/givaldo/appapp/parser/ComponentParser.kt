package dev.givaldo.appapp.parser

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.givaldo.appapp.model.component.AppImage
import dev.givaldo.appapp.model.component.AppSpacer
import dev.givaldo.appapp.model.component.AppText
import dev.givaldo.appapp.model.component.AppText.AppFontWeight
import dev.givaldo.appapp.model.component.AppText.AppFontWeight.*

@Composable
fun AppText.ComposeText(
    modifier: Modifier = Modifier,
) {
    Text(
        text = this.value,
        fontSize = this.size.sp,
        modifier = modifier.appModifier(this.params),
        fontWeight = this.weight.composeFontWeight(),
    )
}

@Composable
fun AppImage.ComposeImage(
    modifier: Modifier = Modifier
) {
    AsyncImage(
        contentScale = ContentScale.Crop,
        model = this.path,
        contentDescription = null,
        modifier = modifier.appModifier(params)
    )
}

@Composable
fun AppSpacer.ComposeSpacer(
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = modifier.appModifier(params)
    )
}

private fun AppFontWeight.composeFontWeight(): FontWeight {
    return when (this) {
        BOLD -> FontWeight.Bold
        NORMAL -> FontWeight.Normal
        SEMI_BOLD -> FontWeight.SemiBold
    }
}