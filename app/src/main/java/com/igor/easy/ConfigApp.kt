package com.igor.easy

import android.app.Application
import com.igor.easy.di.appModule
import org.koin.core.context.startKoin

class ConfigApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(appModule))
        }

    }

}