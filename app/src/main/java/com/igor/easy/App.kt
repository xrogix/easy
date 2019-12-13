package com.igor.easy

import android.app.Application
import com.igor.easy.di.appModule
import com.igor.easy.di.appViewModel
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appViewModel)
            modules(appModule)
        }
    }

}