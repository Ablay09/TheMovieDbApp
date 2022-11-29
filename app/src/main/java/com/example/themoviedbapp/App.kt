package com.example.themoviedbapp

import android.app.Application
import com.example.themoviedbapp.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        loadModules()
    }

    private fun loadModules() {
        startKoin {
            androidContext(this@App)
            modules(allModules)

        }
    }
}