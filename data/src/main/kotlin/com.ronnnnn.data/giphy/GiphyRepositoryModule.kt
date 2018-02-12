package com.ronnnnn.data.giphy

import com.ronnnnn.data.giphy.gifs.GifsModule
import com.ronnnnn.data.giphy.gifs.GifsRepository
import com.ronnnnn.data.giphy.gifs.GifsRepositoryClient
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by kokushiseiya on 2018/02/07.
 */
@Module(includes = [GifsModule::class])
abstract class GiphyRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindGifsRepository(gifsRepositoryClient: GifsRepositoryClient): GifsRepository
}