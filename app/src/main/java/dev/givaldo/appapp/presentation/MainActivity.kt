package dev.givaldo.appapp.presentation

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import dev.givaldo.appapp.R
import dev.givaldo.appapp.deserializer.appView
import dev.givaldo.appapp.parser.AppCompose
import dev.givaldo.appapp.presentation.ui.theme.AppAppTheme

class MainViewModel : ViewModel() {

    val view: MutableState<String> = mutableStateOf(getRes())

    private fun getRes(): String {
        return globalApplication!!.resources.openRawResource(R.raw.sample).bufferedReader()
            .use { it.readText() }
    }
}

var globalApplication: Application? = null


class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        globalApplication = this.application
        setContent {
            AppAppTheme {
                Surface(
//                    color = Color.Cyan,
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(viewModel.view.value)
                }
            }
        }
    }
}

@Composable
fun Greeting(json: String) {
    val map = remember { Gson().fromJson(json, Map::class.java) }

    map.appView().forEach {
        it.AppCompose()
    }
}

