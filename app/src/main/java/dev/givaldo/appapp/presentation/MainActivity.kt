package dev.givaldo.appapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.Gson
import dev.givaldo.appapp.R
import dev.givaldo.appapp.model.component.component
import dev.givaldo.appapp.presentation.ui.theme.AppAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val json = resources.openRawResource(R.raw.sample).bufferedReader().use { it.readText() }
                    Greeting(json)
                }
            }
        }
    }
}

@Composable
fun Greeting(json: String) {

    val map = Gson().fromJson(json, Map::class.java)
    Row(content = {
        map.component().forEach {
            it.AppCompose(Modifier.fillMaxWidth().wrapContentHeight())
        }
    })
}

