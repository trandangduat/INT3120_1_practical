package com.example.flightsearch.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val PREFS_NAME = "user_prefs"
val Context.dataStore by preferencesDataStore(name = PREFS_NAME)

class UserPreferencesRepository(private val context: Context) {
    private val SEARCH_QUERY = stringPreferencesKey("search_query")

    val searchQuery: Flow<String> = context.dataStore.data.map { prefs ->
        prefs[SEARCH_QUERY] ?: ""
    }

    suspend fun saveSearchQuery(query: String) {
        context.dataStore.edit { prefs ->
            prefs[SEARCH_QUERY] = query
        }
    }
}
