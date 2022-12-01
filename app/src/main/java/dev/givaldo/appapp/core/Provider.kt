package dev.givaldo.appapp.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.google.gson.Gson

@Composable
fun AppScreen(json: String) {
    val map = remember { Gson().fromJson(json, Map::class.java) }
    AppViewDeserializer.deserializeMap(map).forEach {
        ComposerAppView(appView = it)
    }
}