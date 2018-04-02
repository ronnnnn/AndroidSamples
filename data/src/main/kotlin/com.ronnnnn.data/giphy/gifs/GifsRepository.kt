package com.ronnnnn.data.giphy.gifs

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.ronnnnn.data.giphy.common.entity.Gif
import com.ronnnnn.data.giphy.gifs.entity.GifByIdData
import com.ronnnnn.data.giphy.gifs.entity.GifsByIdsData
import com.ronnnnn.data.giphy.gifs.entity.RandomData
import com.ronnnnn.data.giphy.gifs.entity.TranslateData
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by kokushiseiya on 2018/02/10.
 */
interface GifsRepository {

    fun observeSearch(
            query: String,
            limit: Int = 25,
            offset: Int = 0,
            rating: String = "",
            language: String = "",
            format: String = "json"
    ): LiveData<PagedList<Gif>>

    fun observeTrending(
            limit: Int = 25,
            offset: Int = 0,
            rating: String = "",
            format: String = "json"
    ): LiveData<PagedList<Gif>>

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