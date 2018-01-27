package com.ronnnnn.androidsamples.repository.giphy.gifs

import com.ronnnnn.data.giphy.gifs.entity.*
import com.ronnnnn.data.giphy.gifs.remote.GifsApi
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/01/27.
 */
class GifsRepository @Inject constructor(private val gifsApi: GifsApi) {

    fun getSearch(
            query: String,
            limit: Int = 25,
            offset: Int = 0,
            rating: String = "",
            language: String = "",
            format: String = "json"
    ): Single<SearchData> =
            gifsApi.getSearch(query, limit, offset, rating, language, format)

    fun getTrending(
            limit: Int = 25,
            offset: Int = 0,
            rating: String = "",
            format: String = "json"
    ): Single<TrendingData> =
            gifsApi.getTrending(limit, offset, rating, format)

    fun getTranslate(searchTerm: String) = gifsApi.getTranslate(searchTerm)

    fun getRandom(
            tag: String = "",
            rating: String = "",
            format: String = "json"
    ): Single<RandomData> = gifsApi.getRandom(tag, rating, format)

    fun getGifById(gifId: String): Single<GifByIdData> = gifsApi.getGifById(gifId)

    fun getGifsByIds(gifsIds: String): Single<GifsByIdsData> = gifsApi.getGifsByIds(gifsIds)
}