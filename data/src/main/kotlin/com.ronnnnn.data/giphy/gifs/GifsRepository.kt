package com.ronnnnn.data.giphy.gifs

import com.ronnnnn.data.giphy.gifs.entity.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by kokushiseiya on 2018/02/10.
 */
interface GifsRepository {

    fun getSearch(
            query: String,
            limit: Int = 25,
            offset: Int = 0,
            rating: String = "",
            language: String = "",
            format: String = "json"
    ): Single<SearchData>

    fun getTrending(
            limit: Int = 25,
            offset: Int = 0,
            rating: String = "",
            format: String = "json"
    ): Single<TrendingData>

    fun getTranslate(searchTerm: String): Single<TranslateData>

    fun fetchRandom(
            tag: String = "",
            rating: String = "",
            format: String = "json"
    ): Completable

    fun observeRandom(): Flowable<RandomData>

    fun getGifById(gifId: String): Single<GifByIdData>

    fun getGifsByIds(gifsIds: String): Single<GifsByIdsData>
}