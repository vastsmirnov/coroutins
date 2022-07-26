package com.vast.coroutines

import android.app.Application
import com.vast.coroutines.data.di.dataModule
import com.vast.coroutines.data.di.networkModule
import com.vast.coroutines.domain.di.domainModule
import com.vast.coroutines.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                presentationModule
                        + domainModule
                        + dataModule
                        + networkModule
            )
        }
    }
}