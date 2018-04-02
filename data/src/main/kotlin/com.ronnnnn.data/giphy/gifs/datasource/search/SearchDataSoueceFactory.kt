package com.ronnnnn.data.giphy.gifs.datasource.search

import android.arch.paging.DataSource
import com.ronnnnn.data.giphy.common.entity.Gif
import com.ronnnnn.data.giphy.gifs.remote.GifsApi

class SearchDataSoueceFactory(
        private val query: String,
        private val gifsApi: GifsApi
) : DataSource.Factory<Int, Gif>() {

    override fun create(): DataSource<Int, Gif> =
            SearchPageKeyedDataSource(query, gifsApi)
}