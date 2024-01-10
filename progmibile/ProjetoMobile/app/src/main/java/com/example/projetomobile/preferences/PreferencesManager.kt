package com.example.projetomobile.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun isAssetSelected(symbol: String): Boolean {
        return sharedPreferences.getBoolean(symbol, false)
    }

    fun setAssetSelected(symbol: String, isSelected: Boolean) {
        sharedPreferences.edit().putBoolean(symbol, isSelected).apply()
    }

    fun clearSelectedAssets() {
        // Iterar sobre as chaves e limpar os ativos selecionados
        val editor = sharedPreferences.edit()
        sharedPreferences.all.keys.forEach { key ->
            if (key != PREFS_NAME) { // Evita limpar o nome das preferências
                editor.remove(key)
            }
        }
        editor.apply()
    }

    companion object {
        private const val PREFS_NAME = "AssetPreferences"
    }
}