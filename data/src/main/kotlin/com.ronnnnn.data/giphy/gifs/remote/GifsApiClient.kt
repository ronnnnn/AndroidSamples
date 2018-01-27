package com.ronnnnn.data.giphy.gifs.remote

import android.content.Context
import com.ronnnnn.data.R
import com.ronnnnn.data.giphy.gifs.entity.*
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/01/27.
 */
class GifsApiClient @Inject constructor(context: Context, retrofit: Retrofit) : GifsApi {

    private val service: GifsService = retrofit.create(GifsService::class.java)
    private val apiKey: String = context.getString(R.string.giphy_api_key)

    override fun getSearch(
            query: String,
            limit: Int,
            offset: Int,
            rating: String,
            language: String,
            format: String
    ): Single<SearchData> =
            service.getSearch(apiKey, query, limit, offset, rating, language, format)

    override fun getTrending(
            limit: Int,
            offset: Int,
            rating: String,
            format: String
    ): Single<TrendingData> =
            service.getTrending(apiKey, limit, offset, rating, format)

    override fun getTranslate(searchTerm: String): Single<TranslateData> =
            service.getTranslate(apiKey, searchTerm)

    override fun getRandom(
            tag: String,
            rating: String,
            format: String
    ): Single<RandomData> =
            service.getRandom(apiKey, tag, rating, format)

    override fun getGifById(gifId: String): Single<GifByIdData> =
            service.getGifById(apiKey, gifId)

    override fun getGifsByIds(gifsIds: String): Single<GifsByIdsData> =
            service.getGifsByIds(apiKey, gifsIds)
}