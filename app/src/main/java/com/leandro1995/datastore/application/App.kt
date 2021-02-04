package com.leandro1995.datastore.application

import android.app.Application
import com.leandro1995.datastore.datastore.DataStore
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        DataStore.instance(context = applicationContext)
    }
}