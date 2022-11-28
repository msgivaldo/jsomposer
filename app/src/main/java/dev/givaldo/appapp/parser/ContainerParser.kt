package dev.givaldo.appapp.parser

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import dev.givaldo.appapp.model.component.AppTopBar
import dev.givaldo.appapp.model.container.*

@Composable
fun AppCard.ComposeCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        shape = composeRadius(),
        modifier = modifier.appModifier(params)
    ) {
        content()
    }
}

@Composable
fun AppColumn.ComposeColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = arrangement.composeArrangement(),
        modifier = modifier.appModifier(params)
    ) {
        content()
    }
}

@Composable
fun AppRow.ComposeRow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Row(
        horizontalArrangement = arrangement.composeArrangement(),
        modifier = modifier.appModifier(params)
    ) {
        content()
    }
}

fun AppTopBar.NavIcon.composeNavIcon(): ImageVector {
    return when (this) {
        AppTopBar.NavIcon.BACK -> Icons.Filled.ArrowBack
        AppTopBar.NavIcon.CLOSE -> Icons.Filled.Close
    }
}

fun AppVerticalArrangement.composeArrangement(): Arrangement.Vertical {
    return when (this) {
        AppVerticalArrangement.TOP -> Arrangement.Top
        AppVerticalArrangement.BOTTOM -> Arrangement.Bottom
    }
}

fun AppHorizontalArrangement.composeArrangement(): Arrangement.Horizontal {
    return when (this) {
        AppHorizontalArrangement.START -> Arrangement.Start
        AppHorizontalArrangement.END -> Arrangement.End
    }
}

fun AppCard.composeRadius(): RoundedCornerShape {
    return RoundedCornerShape(this.radius.dp)
}