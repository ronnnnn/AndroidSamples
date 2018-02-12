package com.ronnnnn.androidsamples.ui

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.ronnnnn.androidsamples.domain.trending.GetTrending
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/02/07.
 */
class MainViewModel @Inject constructor(getTrending: GetTrending): ViewModel() {

    val title: ObservableField<String> = ObservableField("")

    init {
        getTrending.invoke()
                .subscribeOn(Schedulers.io())
                .subscribe({ trendingData ->
                    title.set(trendingData.data[0].title)
                })
    }
}