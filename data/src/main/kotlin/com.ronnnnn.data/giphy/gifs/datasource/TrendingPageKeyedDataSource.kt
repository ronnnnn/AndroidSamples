package com.ronnnnn.data.giphy.gifs.datasource

import android.arch.paging.PageKeyedDataSource
import com.ronnnnn.data.giphy.common.entity.Gif
import com.ronnnnn.data.giphy.gifs.entity.TrendingData
import com.ronnnnn.data.giphy.gifs.remote.GifsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by kokushiseiya on 2018/03/23.
 */
class TrendingPageKeyedDataSource(
        private val gifsApi: GifsApi
) : PageKeyedDataSource<Int, Gif>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Gif>) {
        gifsApi.getTrending(params.requestedLoadSize, 0, "", "json")
                .enqueue(object : Callback<TrendingData> {
                    override fun onFailure(call: Call<TrendingData>?, t: Throwable?) {
                        Timber.e(t)
                    }

                    override fun onResponse(call: Call<TrendingData>?, response: Response<TrendingData>?) {
                        response ?: return
                        if (response.isSuccessful) {
                            val trendingData = response.body() ?: return
                            callback.onResult(
                                    trendingData.data,
                                    null,
                                    trendingData.pagination.offset + trendingData.pagination.count
                            )
                        } else {
                            Timber.e(response.errorBody()?.string())
                        }
                    }
                })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Gif>) {
        gifsApi.getTrending(params.requestedLoadSize, params.key, "", "json")
                .enqueue(object : Callback<TrendingData> {
                    override fun onFailure(call: Call<TrendingData>?, t: Throwable?) {
                        Timber.e(t)
                    }

                    override fun onResponse(call: Call<TrendingData>?, response: Response<TrendingData>?) {
                        response ?: return
                        if (response.isSuccessful) {
                            val trendingData = response.body() ?: return
                            callback.onResult(
                                    trendingData.data,
                                    trendingData.pagination.offset + trendingData.pagination.count
                            )
                        } else {
                            Timber.e(response.errorBody()?.string())
                        }
                    }
                })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Gif>) {
        // no-op
    }
}