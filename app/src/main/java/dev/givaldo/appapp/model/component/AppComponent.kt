package dev.givaldo.appapp.model.component

open class AppComponent(
    open val params: AppComponentParams?
): View()

class AppComponentParams(
    override val paddings: AppDimens,
    override val margins: AppDimens,
    override val width: Float,//match_parent
    override val height: Float,//match_parent
    val background: Int?,
): Params(paddings, margins, width, height) {
    constructor(
        paddings: AppDimens?,
        margins: AppDimens?,
        width: Float?,
        height: Float?,
        background: Int?
    ) : this(
        paddings = paddings ?: AppDimens(),
        margins = margins ?: AppDimens(),
        width = width ?: 0F,
        height = height ?: 0F,
        background
    )
}