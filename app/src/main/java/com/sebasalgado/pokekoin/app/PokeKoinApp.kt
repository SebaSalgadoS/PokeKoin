package com.sebasalgado.pokekoin.app

import android.app.Application
import com.sebasalgado.pokekoin.di.ApiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class PokeKoinApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(){
            androidContext(this@PokeKoinApp)
            modules(ApiModule)
        }
    }
}