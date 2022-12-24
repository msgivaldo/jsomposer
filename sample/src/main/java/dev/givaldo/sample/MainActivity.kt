package dev.givaldo.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.givaldo.jsompoder.sample.R
import dev.givaldo.jsomposer.Jsomposer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Jsomposer.open(this, fetchJsonView())
    }

    private fun fetchJsonView(): String {
        return resources.openRawResource(R.raw.sample).bufferedReader().use { it.readText() }
    }

}

