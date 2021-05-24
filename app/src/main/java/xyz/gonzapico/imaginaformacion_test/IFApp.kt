package xyz.gonzapico.imaginaformacion_test

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import xyz.gonzapico.imaginaformacion_test.di.allModules

class IFApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(org.koin.core.logger.Level.DEBUG)
            androidContext(this@IFApp)
            modules(allModules)
        }
    }
}