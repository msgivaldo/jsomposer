package dev.givaldo.jsomposer

import android.content.Context

object Jsomposer {

    fun open(context: Context, json: String) {
        context.startActivity(JsomposerActivity.newIntent(context, json))
    }
}

