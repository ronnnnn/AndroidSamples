package com.ronnnnn.data.giphy.gifs

import com.ronnnnn.data.giphy.gifs.entity.*
import com.ronnnnn.data.giphy.gifs.remote.GifsApi
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/01/27.
 */
class GifsRepositoryClient @Inject constructor(private val gifsApi: GifsApi) : GifsRepository {

    override fun getSearch(
            query: String,
            limit: Int,
            offset: Int,
            rating: String,
            language: String,
            format: String
    ): Single<SearchData> =
            gifsApi.getSearch(query, limit, offset, rating, language, format)

    override fun getTrending(
            limit: Int,
            offset: Int,
            rating: String,
            format: String
    ): Single<TrendingData> =
            gifsApi.getTrending(limit, offset, rating, format)

    override fun getTranslate(searchTerm: String): Single<TranslateData> =
            gifsApi.getTranslate(searchTerm)

    override fun getRandom(
            tag: String,
            rating: String,
            format: String
    ): Single<RandomData> = gifsApi.getRandom(tag, rating, format)

    override fun getGifById(gifId: String): Single<GifByIdData> = gifsApi.getGifById(gifId)

    override fun getGifsByIds(gifsIds: String): Single<GifsByIdsData> = gifsApi.getGifsByIds(gifsIds)
}