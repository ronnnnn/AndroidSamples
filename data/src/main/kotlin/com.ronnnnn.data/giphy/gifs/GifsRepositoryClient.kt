package com.ronnnnn.data.giphy.gifs

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.ronnnnn.data.giphy.common.entity.Gif
import com.ronnnnn.data.giphy.gifs.datasource.search.SearchDataSoueceFactory
import com.ronnnnn.data.giphy.gifs.datasource.trending.TrendingDataSourceFactory
import com.ronnnnn.data.giphy.gifs.entity.GifByIdData
import com.ronnnnn.data.giphy.gifs.entity.GifsByIdsData
import com.ronnnnn.data.giphy.gifs.entity.RandomData
import com.ronnnnn.data.giphy.gifs.entity.TranslateData
import com.ronnnnn.data.giphy.gifs.local.GifsDb
import com.ronnnnn.data.giphy.gifs.remote.GifsApi
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/01/27.
 */
class GifsRepositoryClient @Inject constructor(
        private val gifsApi: GifsApi,
        private val gifsDb: GifsDb
) : GifsRepository {

    override fun observeSearch(
            query: String,
            limit: Int,
            offset: Int,
            rating: String,
            language: String,
            format: String
    ): LiveData<PagedList<Gif>> {
        val dataSourceFactory = SearchDataSoueceFactory(query, gifsApi)

        val config = PagedList.Config.Builder()
                .setInitialLoadSizeHint(limit)
                .setPageSize(limit)
                .setEnablePlaceholders(false)
                .build()

        return LivePagedListBuilder(dataSourceFactory, config)
                .build()
    }

    override fun observeTrending(
            limit: Int,
            offset: Int,
            rating: String,
            format: String
    ): LiveData<PagedList<Gif>> {
        val dataSourceFactory = TrendingDataSourceFactory(gifsApi)

        val config = PagedList.Config.Builder()
                .setInitialLoadSizeHint(limit)
                .setPageSize(limit)
                .setEnablePlaceholders(false)
                .build()

        return LivePagedListBuilder(dataSourceFactory, config)
                .build()
    }

    override fun getTranslate(searchTerm: String): Single<TranslateData> =
            gifsApi.getTranslate(searchTerm)

    override fun fetchRandom(
            tag: String,
            rating: String,
            format: String
    ): Completable =
            gifsApi.getRandom(tag, rating, format)
                    .flatMapCompletable { randomData -> gifsDb.updateRandom(randomData) }

    override fun observeRandom(): Flowable<RandomData> = gifsDb.observeRandom()

    override fun getGifById(gifId: String): Single<GifByIdData> = gifsApi.getGifById(gifId)

    override fun getGifsByIds(gifsIds: String): Single<GifsByIdsData> = gifsApi.getGifsByIds(gifsIds)
}