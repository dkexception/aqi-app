package com.dkexception.core

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStore @Inject constructor(
    private val preferences: SharedPreferences
) {

    fun containsKey(key: String): Boolean = preferences.contains(key)

    fun deleteKey(key: String) = preferences.edit(true) {
        remove(key)
    }

    fun nuke() = preferences.edit(true) {
        clear()
    }

    // Strings
    fun saveString(key: String, value: String) = preferences.edit {
        putString(key, value)
    }

    fun getString(key: String, default: String? = null): String? =
        preferences.getString(key, default)

    // Boolean
    fun saveBoolean(key: String, value: Boolean) = preferences.edit {
        putBoolean(key, value)
    }

    fun getBoolean(key: String, default: Boolean): Boolean = preferences.getBoolean(key, default)
}
