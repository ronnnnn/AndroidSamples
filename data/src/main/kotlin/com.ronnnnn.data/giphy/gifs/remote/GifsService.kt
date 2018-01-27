package com.ronnnnn.data.giphy.gifs.remote

import com.ronnnnn.data.giphy.gifs.entity.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by kokushiseiya on 2018/01/27.
 */
interface GifsService {

    @GET("gifs/search")
    fun getSearch(
            @Query("api_key")
            apiKey: String,
            @Query("q")
            query: String,
            @Query("limit")
            limit: Int,
            @Query("offset")
            offset: Int,
            @Query("rating")
            rating: String,
            @Query("lang")
            language: String,
            @Query("fmt")
            format: String
    ): Single<SearchData>

    @GET("gifs/trending")
    fun getTrending(
            @Query("api_key")
            apiKey: String,
            @Query("limit")
            limit: Int,
            @Query("offset")
            offset: Int,
            @Query("rating")
            rating: String,
            @Query("fmt")
            format: String
    ): Single<TrendingData>

    @GET("gifs/translate")
    fun getTranslate(
            @Query("api_key")
            apiKey: String,
            @Query("s")
            searchTerm: String
    ): Single<TranslateData>

    @GET("gifs/random")
    fun getRandom(
            @Query("api_key")
            apiKey: String,
            @Query("tag")
            tag: String,
            @Query("rating")
            rating: String,
            @Query("fmt")
            format: String
    ): Single<RandomData>

    @GET("gifs/{gif_id}")
    fun getGifById(
            @Query("api_key")
            apiKey: String,
            @Path("gif_id")
            gifId: String
    ): Single<GifByIdData>

    @GET("gifs")
    fun getGifsByIds(
            @Query("api_key")
            apiKey: String,
            @Query("ids")
            gifsIds: String
    ): Single<GifsByIdsData>
}