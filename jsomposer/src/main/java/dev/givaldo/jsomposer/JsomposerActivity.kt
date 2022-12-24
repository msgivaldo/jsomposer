package dev.givaldo.jsomposer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.gson.Gson
import dev.givaldo.jsomposer.compose.theme.JsomposerTheme
import dev.givaldo.jsomposer.core.app.AppViewDeserializer
import dev.givaldo.jsomposer.core.app.ComposerAppView
import dev.givaldo.jsomposer.datasource.JsomposerDataSource

internal class JsomposerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val json = JsomposerDataSource.fetchJsonOnce(this@JsomposerActivity) ?: return

        setContent {
            JsomposerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.White
                ) {
                    AppScreen(json = json)
                }
            }
        }
    }

    @Composable
    fun AppScreen(json: String) {
        val map = remember { Gson().fromJson(json, Map::class.java) }
        AppViewDeserializer.deserializeMap(map).forEach {
            ComposerAppView(appView = it)
        }
    }

    companion object {
        fun newIntent(context: Context, json: String): Intent {
            JsomposerDataSource.saveJson(context, json)
            return Intent(context, JsomposerActivity::class.java)
        }
    }
}