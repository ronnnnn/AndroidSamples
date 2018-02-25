package com.ronnnnn.androidsamples.domain.trending

import android.support.annotation.CheckResult
import com.ronnnnn.data.giphy.gifs.GifsRepository
import com.ronnnnn.data.giphy.gifs.entity.TrendingData
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/02/08.
 */
class TrendingUseCase @Inject constructor(private val gifsRepository: GifsRepository) {

    @CheckResult
    fun get(): Single<TrendingData> = gifsRepository.getTrending()
}