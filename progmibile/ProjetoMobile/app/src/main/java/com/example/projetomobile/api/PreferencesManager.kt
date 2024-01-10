package com.example.projetomobile.api

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    companion object {
        private const val PREFERENCES_NAME = "YourAppPreferences"
        private const val KEY_SELECTED_ASSETS = "SelectedAssets"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun saveSelectedAssets(selectedAssets: Set<String>) {
        preferences.edit().putStringSet(KEY_SELECTED_ASSETS, selectedAssets).apply()
    }

    fun getSelectedAssets(): Set<String> {
        return preferences.getStringSet(KEY_SELECTED_ASSETS, emptySet()) ?: emptySet()
    }

    fun clearSelectedAssets() {
        preferences.edit().remove(KEY_SELECTED_ASSETS).apply()
    }
}
