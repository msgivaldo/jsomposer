package dev.givaldo.jsomposer.core

import androidx.compose.runtime.Composable
import dev.givaldo.jsomposer.core.app.AppComponent
import dev.givaldo.jsomposer.core.app.AppView
import dev.givaldo.jsomposer.view.container.AppContainer

interface Deserializer<out T : AppView> {
    val key: String

    fun deserialize(value: Map<*, *>?): T
}

interface AppComponentComposer<T : AppComponent> {

    @Composable
    fun CreateComponent(appComponent: T)

}


interface AppContainerComposer<T : AppContainer> {

    @Composable
    fun CreateComponent(appView: T, content: @Composable (() -> Unit))

}