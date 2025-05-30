package com.example.appfinanzas.data

import android.content.Context
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

object UserPreferences {
    private val Context.dataStore by preferencesDataStore(name = "user_prefs")

    private val NAME_KEY = stringPreferencesKey("user_name")
    private val SALARY_KEY = doublePreferencesKey("user_salary")

    suspend fun saveUserData(context: Context, name: String, salary: Double) {
        context.dataStore.edit { prefs ->
            prefs[NAME_KEY] = name
            prefs[SALARY_KEY] = salary
        }
    }

    suspend fun getUserData(context: Context): Pair<String?, Double?> {
        val prefs = context.dataStore.data.first()
        return Pair(prefs[NAME_KEY], prefs[SALARY_KEY])
    }

    suspend fun clear(context: Context) {
        context.dataStore.edit { it.clear() }
    }
}
