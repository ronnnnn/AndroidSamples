package com.ronnnnn.data.giphy.gifs.datasource.search

import android.arch.paging.PageKeyedDataSource
import com.ronnnnn.data.giphy.common.entity.Gif
import com.ronnnnn.data.giphy.gifs.entity.SearchData
import com.ronnnnn.data.giphy.gifs.remote.GifsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class SearchPageKeyedDataSource(
        private val query: String,
        private val gifsApi: GifsApi
) : PageKeyedDataSource<Int, Gif>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Gif>) =
            gifsApi.getSearch(query, params.requestedLoadSize, 0, "", "en", "json")
                    .enqueue(object : Callback<SearchData> {
                        override fun onFailure(call: Call<SearchData>?, t: Throwable?) {
                            Timber.e(t)
                        }

                        override fun onResponse(call: Call<SearchData>?, response: Response<SearchData>?) {
                            response ?: return
                            if (response.isSuccessful) {
                                val searchData = response.body() ?: return
                                callback.onResult(
                                        searchData.data,
                                        null,
                                        searchData.pagination.offset + searchData.pagination.count
                                )
                            } else {
                                Timber.e(response.errorBody()?.string())
                            }
                        }

                    })

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Gif>) {
        gifsApi.getSearch(query, params.requestedLoadSize, params.key, "", "en", "json")
                .enqueue(object : Callback<SearchData> {
                    override fun onFailure(call: Call<SearchData>?, t: Throwable?) {
                        Timber.e(t)
                    }

                    override fun onResponse(call: Call<SearchData>?, response: Response<SearchData>?) {
                        response ?: return
                        if (response.isSuccessful) {
                            val searchData = response.body() ?: return
                            callback.onResult(
                                    searchData.data,
                                    searchData.pagination.offset + searchData.pagination.count
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