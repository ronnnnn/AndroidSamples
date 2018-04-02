package com.ronnnnn.androidsamples.domain.trending

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import android.support.annotation.CheckResult
import com.ronnnnn.data.giphy.common.entity.Gif
import com.ronnnnn.data.giphy.gifs.GifsRepository
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/02/08.
 */
class TrendingUseCase @Inject constructor(private val gifsRepository: GifsRepository) {

    @CheckResult
    fun observe(): LiveData<PagedList<Gif>> = gifsRepository.observeTrending()
}