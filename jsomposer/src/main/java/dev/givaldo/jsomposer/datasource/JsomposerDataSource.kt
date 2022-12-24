package dev.givaldo.jsomposer.datasource

import android.content.Context
import androidx.core.content.edit

object JsomposerDataSource {

    private const val JSOMPOSER_PREF = "JSOMPOSER_PREF_NAME"
    private const val JSOMPOSER_KEY = "JSOMPOSER_PREF_KEY"

    private fun Context.getPrefs() = getSharedPreferences(JSOMPOSER_PREF, Context.MODE_PRIVATE)

    fun saveJson(context: Context, json: String) {
        context.getPrefs().edit {
            putString(JSOMPOSER_KEY, json)
        }
    }

    fun fetchJsonOnce(context: Context): String? {
        val result =
            context.getPrefs().getString(JSOMPOSER_KEY, "").takeIf { it.isNullOrBlank().not() }
        context.getPrefs().edit().clear().apply()
        return result
    }

}