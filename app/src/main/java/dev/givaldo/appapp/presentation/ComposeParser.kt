package dev.givaldo.appapp.presentation

import Container
import ContainerParams
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.givaldo.appapp.model.component.*

@Composable
fun View.AppCompose(
    modifier: Modifier
) {
    when (this) {
        is Container -> {
            when (this.params?.type) {
                ContainerType.CARD -> {
                    AppCard(modifier = modifier) {
                        this.items.map {
                            it.AppCompose(modifier = modifier)
                        }
                    }
                }
                ContainerType.COLUMN -> {
                    AppColumn(modifier = modifier) {
                        this.items.map {
                            it.AppCompose(modifier = modifier)
                        }
                    }
                }
                ContainerType.ROW -> {
                    AppRow(modifier = modifier) {
                        this.items.map {
                            it.AppCompose(modifier = modifier)
                        }
                    }
                }
                else -> {}
            }
        }
        is AppComponent -> {
            when (this) {
                is AppText -> {
                    androidx.compose.material.Text(
                        text = this.value,
                        fontSize = this.size.sp,
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth(),
                        fontWeight = this.weight.fontWeight(),
                    )
                }
                is AppImage -> {
                    AsyncImage(
                        model = this.path,
                        contentDescription = null,
                        modifier = Modifier
                            .width(this.params.width.dp)
                            .height(this.params.height.dp)
                    )
                }
                is AppSpacer -> {
                    Spacer(
                        modifier = Modifier
                            .width(this.params.width.dp)
                            .height(this.params.height.dp)
                    )
                }
                else -> error("unexpected component type")
            }
        }
        else -> error("unexpected container type")
    }
}

@Composable
fun Container.AppCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val modifier1 = params
        .width(modifier)
        .padding(params.padding())

    Card(modifier = modifier1) {
        content()
    }

}

@Composable
fun Container.AppColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val modifier1 = params
        .width(modifier)
        .padding(params.padding())

    Column(modifier = modifier1) {
        content()
    }

}

@Composable
fun Container.AppRow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val modifier1 = params
        .width(modifier)
        .padding(params.padding())

    Row(modifier = modifier1) {
        content()
    }
}

private fun ContainerParams?.width(
    modifier: Modifier
): Modifier {
    return if (this == null) modifier.fillMaxWidth() else modifier.width(width.dp)
}

private fun AppFontWeight.fontWeight(): FontWeight {
    return when(this) {
        AppFontWeight.BOLD -> FontWeight.Bold
        AppFontWeight.NORMAL -> FontWeight.Normal
        AppFontWeight.SEMI_BOLD -> FontWeight.SemiBold
    }
}

@Composable
private fun ContainerParams?.padding(): PaddingValues {
    if (this == null) return PaddingValues(0.dp)

    return PaddingValues(
        start = paddings.start.dp,
        end = paddings.end.dp,
        top = paddings.top.dp,
        bottom = paddings.bottom.dp
    )
}


//private fun Params?.width(
//    modifier: Modifier
//): Modifier {
//    return if (this == null) modifier.fillMaxWidth() else modifier.width(width.dp)
//}

private fun Params?.height(
    modifier: Modifier
): Modifier {
    return if (this == null) modifier.fillMaxHeight() else modifier.height(height = height.dp)
}

@Composable
private fun Params?.padding(): PaddingValues {
    if (this == null) return PaddingValues(0.dp)

    return PaddingValues(
        start = paddings.start.dp,
        end = paddings.end.dp,
        top = paddings.top.dp,
        bottom = paddings.bottom.dp
    )
}