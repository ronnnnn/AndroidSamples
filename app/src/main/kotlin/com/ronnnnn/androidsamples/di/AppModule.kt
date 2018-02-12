package com.ronnnnn.androidsamples.di

import android.content.Context
import com.ronnnnn.androidsamples.App
import dagger.Module
import dagger.Provides

/**
 * Created by kokushiseiya on 2018/01/28.
 */
@Module
class AppModule(private val app: App) {

    @Provides
    fun provideContext(): Context = app.applicationContext
}