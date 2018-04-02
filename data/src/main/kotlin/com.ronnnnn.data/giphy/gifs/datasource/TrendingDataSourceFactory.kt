package com.ronnnnn.data.giphy.gifs.datasource

import android.arch.paging.DataSource
import com.ronnnnn.data.giphy.common.entity.Gif
import com.ronnnnn.data.giphy.gifs.remote.GifsApi

/**
 * Created by kokushiseiya on 2018/03/23.
 */
class TrendingDataSourceFactory(
        private val gifsApi: GifsApi
) : DataSource.Factory<Int, Gif>() {

    override fun create(): DataSource<Int, Gif> =
            TrendingPageKeyedDataSource(gifsApi)
}