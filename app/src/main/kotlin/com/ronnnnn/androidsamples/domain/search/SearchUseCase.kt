package com.ronnnnn.androidsamples.domain.search

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import android.support.annotation.CheckResult
import com.ronnnnn.data.giphy.common.entity.Gif
import com.ronnnnn.data.giphy.gifs.GifsRepository
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val gifsRepository: GifsRepository) {

    @CheckResult
    fun observe(query: String): LiveData<PagedList<Gif>> = gifsRepository.observeSearch(query)
}