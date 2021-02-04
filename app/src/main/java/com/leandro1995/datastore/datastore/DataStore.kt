package com.leandro1995.datastore.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first


object DataStore {
    private lateinit var dataStore: DataStore<Preferences>
    private lateinit var preferences: Preferences

    private lateinit var stringDataStoreKey: Preferences.Key<String>
    private lateinit var intDataStoreKey: Preferences.Key<Int>

    private const val DATA_STORE_NAME = "data_store"
    private const val NAME = "name"
    private const val AGE = "age"

    suspend fun instance(context: Context) {
        dataStore = context.createDataStore(name = DATA_STORE_NAME)
        preferences = dataStore.data.first()
    }

    suspend fun setMessage(value: String) {
        stringDataStoreKey = stringPreferencesKey(NAME)

        dataStore.edit { preference ->
            preference[stringDataStoreKey] = value
        }
    }

    fun getMessage(): String {
        stringDataStoreKey = stringPreferencesKey(NAME)
        return preferences[stringDataStoreKey] ?: ""
    }

    suspend fun setAge(value: Int) {
        intDataStoreKey = intPreferencesKey(AGE)

        dataStore.edit { preference ->
            preference[intDataStoreKey] = value
        }
    }

    fun getAge(): Int {
        intDataStoreKey = intPreferencesKey(AGE)
        return preferences[intDataStoreKey] ?: -1
    }
}