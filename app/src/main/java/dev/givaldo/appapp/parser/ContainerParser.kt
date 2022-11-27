package dev.givaldo.appapp.parser

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.givaldo.appapp.model.container.AppCard
import dev.givaldo.appapp.model.container.AppColumn
import dev.givaldo.appapp.model.container.AppRow

@Composable
fun AppCard.ComposeCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(modifier = modifier.appModifier(params)) {
        content()
    }
}

@Composable
fun AppColumn.ComposeColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier.appModifier(params)) {
        content()
    }
}

@Composable
fun AppRow.ComposeRow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Row(modifier = modifier.appModifier(params)) {
        content()
    }
}