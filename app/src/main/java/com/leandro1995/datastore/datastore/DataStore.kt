package com.leandro1995.datastore.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first


object DataStore {
    private lateinit var dataStore: DataStore<Preferences>
    private lateinit var dataStoreKey: Preferences.Key<String>
    private lateinit var preferences: Preferences

    private const val DATA_STORE_NAME = "data_store"
    private const val MESSAGE = "message"

    suspend fun instance(context: Context) {
        dataStore = context.createDataStore(name = DATA_STORE_NAME)
        preferences = dataStore.data.first()
    }

    suspend fun setMessage(value: String) {
        dataStoreKey = stringPreferencesKey(MESSAGE)

        dataStore.edit { preference ->
            preference[dataStoreKey] = value
        }
    }

    fun getMessage(): String? {
        dataStoreKey = stringPreferencesKey(MESSAGE)
        return preferences[dataStoreKey]
    }
}