package com.ronnnnn.data.giphy.gifs.remote

import com.ronnnnn.data.giphy.gifs.entity.*
import io.reactivex.Single

/**
 * Created by kokushiseiya on 2018/01/27.
 */
interface GifsApi {

    fun getSearch(
            query: String,
            limit: Int,
            offset: Int,
            rating: String,
            language: String,
            format: String
    ): Single<SearchData>

    fun getTrending(
            limit: Int,
            offset: Int,
            rating: String,
            format: String
    ): Single<TrendingData>

    fun getTranslate(
            searchTerm: String
    ): Single<TranslateData>

    fun getRandom(
            tag: String,
            rating: String,
            format: String
    ): Single<RandomData>

    fun getGifById(
            gifId: String
    ): Single<GifByIdData>

    fun getGifsByIds(
            gifsIds: String
    ): Single<GifsByIdsData>
}