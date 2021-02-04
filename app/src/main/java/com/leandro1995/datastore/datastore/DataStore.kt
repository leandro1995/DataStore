package com.leandro1995.datastore.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore


object DataStore {
    private lateinit var dataStore: DataStore<Preferences>

    private const val DATA_STORE_NAME = "data_store"

    fun instance(context: Context) {
        dataStore = context.createDataStore(name = DATA_STORE_NAME)
    }
}