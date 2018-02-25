package com.ronnnnn.data.giphy.gifs

import com.ronnnnn.data.giphy.gifs.local.GifsDb
import com.ronnnnn.data.giphy.gifs.local.GifsMemoryClient
import com.ronnnnn.data.giphy.gifs.remote.GifsApi
import com.ronnnnn.data.giphy.gifs.remote.GifsApiClient
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2018/02/07.
 */
@Module
abstract class GifsModule {

    @Singleton
    @Binds
    abstract fun bindGifsApi(gifsApiClient: GifsApiClient): GifsApi

    @Singleton
    @Binds
    abstract fun bindGifsDb(gifsMemoryClient: GifsMemoryClient): GifsDb
}