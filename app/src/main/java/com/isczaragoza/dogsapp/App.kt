package com.isczaragoza.dogsapp

import android.app.Application
import com.isczaragoza.dogsapp.data.di.dataModule
import com.isczaragoza.dogsapp.domain.di.domainModule
import com.isczaragoza.dogsapp.framework.di.frameworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@App)
            // Load modules
            modules(frameworkModule, dataModule, domainModule)
        }
    }
}