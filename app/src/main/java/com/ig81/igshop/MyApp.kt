package com.ig81.igshop

import android.app.Application
import com.ig81.igshop.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
       startKoin {
            androidContext(this@MyApp)
            modules(appModule)
        }
    }
}