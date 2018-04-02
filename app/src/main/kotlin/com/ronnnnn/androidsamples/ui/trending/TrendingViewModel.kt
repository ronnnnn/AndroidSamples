package com.ronnnnn.androidsamples.ui.trending

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.ronnnnn.androidsamples.domain.trending.TrendingUseCase
import com.ronnnnn.data.giphy.common.entity.Gif
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/03/22.
 */
class TrendingViewModel @Inject constructor(private val trendingUseCase: TrendingUseCase) : ViewModel() {

    fun observeTrendingData(): LiveData<PagedList<Gif>> =
            trendingUseCase.observe()
}