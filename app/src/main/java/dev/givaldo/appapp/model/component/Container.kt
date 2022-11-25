import dev.givaldo.appapp.model.component.AppDimens
import dev.givaldo.appapp.model.component.View

data class Container(
    val items: List<View>,
    val params: ContainerParams?,
): View()

data class ContainerParams(
    val paddings: AppDimens,
    val margins: AppDimens,
    val width: Float,//match_parent
    val height: Float,//match_parent
    val background: Int?,
    val type: ContainerType,
) {
    constructor(
        paddings: AppDimens?,
        margins: AppDimens?,
        width: Float?,
        height: Float?,
        background: Int?,
        type: ContainerType
    ) : this(
        paddings = paddings ?: AppDimens(),
        margins = margins ?: AppDimens(),
        width = width ?: 0F,
        height = height ?: 0F,
        background = background,
        type = type
    )
}

enum class ContainerType {
    COLUMN, CARD, ROW
}