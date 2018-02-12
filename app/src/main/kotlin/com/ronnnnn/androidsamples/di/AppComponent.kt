package com.ronnnnn.androidsamples.di

import com.ronnnnn.androidsamples.viewmodel.ViewModelModule
import com.ronnnnn.data.RemoteModule
import com.ronnnnn.data.giphy.GiphyRepositoryModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2018/01/28.
 */
@Singleton
@Component(modules = [
    AppModule::class,
    ViewModelModule::class,
    GiphyRepositoryModule::class,
    RemoteModule::class
])
interface AppComponent : ViewModelModule.Provider