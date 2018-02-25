package com.ronnnnn.androidsamples.domain.random

import android.support.annotation.CheckResult
import com.ronnnnn.data.giphy.gifs.GifsRepository
import com.ronnnnn.data.giphy.gifs.entity.RandomData
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by kokushiseiya on 2018/02/26.
 */
class RandomUseCase @Inject constructor(private val gifsRepository: GifsRepository) {

    @CheckResult
    fun fetch(tag: String): Completable = gifsRepository.fetchRandom(tag)

    @CheckResult
    fun observe(): Flowable<RandomData> = gifsRepository.observeRandom()
}