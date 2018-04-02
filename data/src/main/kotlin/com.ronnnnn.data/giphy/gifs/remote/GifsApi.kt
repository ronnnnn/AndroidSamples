package com.ronnnnn.data.giphy.gifs.remote

import com.ronnnnn.data.giphy.gifs.entity.*
import io.reactivex.Single
import retrofit2.Call

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
    ): Call<SearchData>

    fun getTrending(
            limit: Int,
            offset: Int,
            rating: String,
            format: String
    ): Call<TrendingData>

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