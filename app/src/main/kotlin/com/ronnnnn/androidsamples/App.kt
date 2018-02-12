package com.ronnnnn.androidsamples

import android.app.Application
import android.content.Context
import com.ronnnnn.androidsamples.di.AppComponent
import com.ronnnnn.androidsamples.di.AppModule
import com.ronnnnn.androidsamples.di.DaggerAppComponent
import timber.log.Timber

/**
 * Created by kokushiseiya on 2018/01/28.
 */
class App : Application() {

    companion object {
        fun get(context: Context) = context.applicationContext as App
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}